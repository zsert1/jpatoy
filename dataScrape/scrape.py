import requests
from bs4 import BeautifulSoup
import json


def get_players(url):
    headers = {
        "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.3"
    }
    response = requests.get(url, headers=headers)
    soup = BeautifulSoup(response.text, "html.parser")

    players = []
    # 플레이어 목록 페이지에서 선수들의 프로필 링크를 추출
    for link in soup.select("a.spielprofil_tooltip"):
        player_url = "https://www.transfermarkt.com" + link["href"]
        player_data = scrape_player_data(player_url, headers)
        players.append(player_data)
        if len(players) >= 50:  # 50명의 선수 데이터만 수집
            break

    return players


def scrape_player_data(player_url, headers):
    response = requests.get(player_url, headers=headers)
    soup = BeautifulSoup(response.text, "html.parser")

    name = soup.find("h1", {"itemprop": "name"}).get_text(strip=True)
    position = soup.find("div", {"class": "dataValue"}).get_text(strip=True)
    team = soup.find("a", {"class": "vereinprofil_tooltip"}).get_text(strip=True)

    # 이 부분은 실제 경기 데이터 구조에 따라 수정 필요
    game_records = []
    table = soup.find("table", class_="items")  # 경기 기록 테이블
    if table:
        for row in table.find_all("tr")[1:]:  # 첫 번째 행은 헤더
            cols = row.find_all("td")
            if len(cols) > 5:
                game_date = cols[1].text.strip()
                opponent = cols[4].text.strip()
                goals = cols[6].text.strip()
                assists = cols[7].text.strip()
                game_records.append(
                    {
                        "gameDate": game_date,
                        "opponent": opponent,
                        "goals": int(goals if goals else 0),
                        "assists": int(assists if assists else 0),
                    }
                )

    player = {
        "name": name,
        "position": position,
        "team": team,
        "gameRecords": game_records,
    }

    return player


if __name__ == "__main__":
    url = "https://www.transfermarkt.com/schnellsuche/ergebnis/schnellsuche?query="  # 선수 목록 페이지 URL
    players = get_players(url)
    # 이 데이터를 JSON 파일로 저장하거나 바로 API로 전송
    print(json.dumps(players, indent=4))
