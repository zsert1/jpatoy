import requests
from bs4 import BeautifulSoup
import json


def get_players(url):
    headers = {
        "User-Agent": "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36"
    }
    response = requests.get(url, headers=headers)
    soup = BeautifulSoup(response.text, "html.parser")

    players = []
    for link in soup.select("a.spielprofil_tooltip"):
        player_url = "https://www.transfermarkt.com" + link["href"]
        player_data = scrape_player_data(player_url, headers)
        players.append(player_data)
        if len(players) >= 50:
            break
    return players


def scrape_player_data(player_url, headers):
    response = requests.get(player_url, headers=headers)
    soup = BeautifulSoup(response.text, "html.parser")

    name = soup.find("h1", {"itemprop": "name"}).get_text(strip=True)
    position = soup.find("div", {"class": "dataValue"}).get_text(strip=True)
    team = soup.find("a", {"class": "vereinprofil_tooltip"}).get_text(strip=True)

    game_records = []
    table = soup.find("table", class_="items")
    if table:
        for row in table.find_all("tr")[1:]:
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


def send_data_to_api(players):
    url = "http://localhost:8080/api/data/scrape"
    headers = {"Content-Type": "application/json"}
    response = requests.post(url, json=players, headers=headers)  # 데이터 전송
    print("Status Code:", response.status_code)
    print("Response:", response.json())  # API 응답 출력


if __name__ == "__main__":
    url = "https://www.transfermarkt.com/schnellsuche/ergebnis/schnellsuche?query="
    players = get_players(url)
    send_data_to_api(players)  # 스크랩한 데이터를 API로 전송
