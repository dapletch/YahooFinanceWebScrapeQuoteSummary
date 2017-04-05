# YahooFinanceWebScrapeQuoteSummary
This application is a proof of concept. I have always wondered how data mining could be done with Java without the direct use of an API. 
I also wanted to learn more about MongoDB, and NoSQL, as well. 
This application takes a ticker symbol from the user and scrapes some data from the following URL, 
like so: http://finance.yahoo.com/quote/${tickerSymbol}. 
Once a ticker symbol has been entered by the user the application scrapes quote summary data from the page using Jsoup. 
After the data has been obtained the application then inserts the data into a collection in MongoDB.
I later wanted to experiment with Apache Drill as a query engine.
Apache Drill, for those that don't know, allows users to write SQL like statements on data that is stored in a non-SQL format,
for example, csv's, delimited text files, and json. I was able to successfully run the program via an IDE,
but the program will not compile into a uber/fat jar, as planned. Definitely something to take into consideration before using Apache Drill.
