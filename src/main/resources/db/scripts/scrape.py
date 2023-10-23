import requests
from bs4 import BeautifulSoup

url = 'https://namu.wiki/w/%EB%9E%9C%EB%8D%A4%20%EB%8A%A5%EB%A0%A5%20%ED%81%AC%EB%9E%98%ED%94%84%ED%8A%B8(%ED%95%98%EC%A0%9C)/%EB%8A%A5%EB%A0%A5%20%EB%A6%AC%EC%8A%A4%ED%8A%B8'
page = requests.get(url)
s = page.text

soup = BeautifulSoup(page.content, 'html.parser')

headings = soup.find_all('h2')

sql_string = "INSERT INTO sc_abilities(name, category, description, win_count, loss_count) VALUES"
sql_list = []

for h2 in headings:
    category = h2.find('span').get('id')
    next = h2.find_next_sibling().find_next_sibling()
    while next.name == 'h3':
        ability_name = next.find('span').get('id')
        if "'" in ability_name:
            ability_name = ability_name.replace("'", "''")
        next = next.find_next_sibling()
        description = next.find('blockquote').find('div').get_text()
        if "'" in description:
            description = description.replace("'", "''")
        next = next.find_next_sibling()

        sql_list.append(f"('{ability_name}', '{category}', '{description}', 0, 0)")

result = sql_string + ", \n".join(sql_list) + ';'

print(result)