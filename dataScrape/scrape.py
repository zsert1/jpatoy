import requests
from bs4 import BeautifulSoup
import json
import re


def get_players(url):
    headers = {
        "User-Agent": "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36"
    }
    response = requests.get(url, headers=headers)
    soup = BeautifulSoup(response.text, "html.parser")
    rows = soup.find_all("tr", class_=["odd", "even"])

    players = []
    for index, row in enumerate(rows):
        player = row.find_all("td")[::-1]
        rank = index + 1
        name = player[11].find("a").text.strip()
        position = player[10].text.strip()
        age = re.findall(r"\d+", player[8].text.strip())[0]
        try:
            club = player[7].find("img")["alt"]
        except TypeError:
            club = "for 2 clubs"
        matches = player[6].find("a").text.strip()
        goals = player[0].find("a").text.strip()
        player_data = {
            "playerRank": int(rank),
            "name": name,
            "position": position,
            "age": int(age),
            "club": club,
            "goals": int(goals),
            "matches": int(matches),
        }

        players.append(player_data)
    return players


def send_data_to_api(players):
    url = "http://localhost:8080/api/data/scrape"
    headers = {"Content-Type": "application/json"}
    response = requests.post(url, json=players, headers=headers)  # 데이터 전송
    print("Status Code:", response.status_code)
    # print("Response:", response.json())  # API 응답 출력


if __name__ == "__main__":
    url = "https://www.transfermarkt.com/premier-league/torschuetzenliste/wettbewerb/GB1/saison_id/2023/altersklasse/alle/detailpos/alle/plus/1"
    players = get_players(url)
    # print(players)
    send_data_to_api(players)
