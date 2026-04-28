import requests
from bs4 import BeautifulSoup
import csv

base_url = "http://books.toscrape.com/"

# Open CSV file
with open("books.csv", "w", newline="", encoding="utf-8") as file:
    writer = csv.writer(file)
    writer.writerow(["Title", "Price", "Rating", "Availability", "Product URL"])

    # Loop through first 50 pages (or change as needed)
    for page in range(1, 51):
        url = base_url + f"catalogue/page-{page}.html"
        response = requests.get(url)
        soup = BeautifulSoup(response.text, "html.parser")

        # Find all book blocks
        books = soup.find_all("article", class_="product_pod")

        if not books:
            break  # Stop if no books (end of pages)

        for book in books:
            # Title and product URL
            a_tag = book.find("h3").find("a")
            title = a_tag["title"]
            book_url = base_url + "catalogue/" + a_tag["href"]

            # Price
            price = book.find("p", class_="price_color").text.strip()

            # Rating (as class name)
            rating_class = book.find("p", class_="star-rating")["class"][1]
            rating = rating_class  # e.g., "Three", "Five", etc.

            # Availability = text under "In stock" or "Out of stock"
            availability = book.find("p", class_="instock availability").text.strip()

            # Write row to CSV
            writer.writerow([title, price, rating, availability, book_url])

        print(f"Page {page} scraped successfully.")

print("All done — data saved to books.csv!")
