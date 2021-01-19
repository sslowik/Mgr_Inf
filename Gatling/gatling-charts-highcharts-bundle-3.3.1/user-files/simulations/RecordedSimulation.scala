
import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class RecordedSimulation extends Simulation {

	val httpProtocol = http
		.baseUrl("http://computer-database.gatling.io")
		.inferHtmlResources()
		.userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/85.0.4183.102 Safari/537.36")

	val headers_0 = Map(
		"Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9",
		"Accept-Encoding" -> "gzip, deflate",
		"Accept-Language" -> "pl,en;q=0.9,pl-PL;q=0.8,en-US;q=0.7",
		"Upgrade-Insecure-Requests" -> "1")

	val headers_6 = Map(
		"Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9",
		"Accept-Encoding" -> "gzip, deflate",
		"Accept-Language" -> "pl,en;q=0.9,pl-PL;q=0.8,en-US;q=0.7",
		"Origin" -> "http://computer-database.gatling.io",
		"Upgrade-Insecure-Requests" -> "1")

	val headers_12 = Map("Upgrade-Insecure-Requests" -> "1")



	val scn = scenario("RecordedSimulation")
		.exec(http("request_0")
			.get("/computers")
			.headers(headers_0)
			.resources(http("request_1")
			.get("/assets/css/bootstrap.min.css"),
            http("request_2")
			.get("/assets/css/main.css")))
		.pause(14)
		.exec(http("request_3")
			.get("/computers/new")
			.headers(headers_0)
			.resources(http("request_4")
			.get("/assets/css/bootstrap.min.css"),
            http("request_5")
			.get("/assets/css/main.css")))
		.pause(41)
		.exec(http("request_6")
			.post("/computers")
			.headers(headers_6)
			.formParam("name", "Slawetny123")
			.formParam("introduced", "1977-11-12")
			.formParam("discontinued", "2077-12-31")
			.formParam("company", "12")
			.resources(http("request_7")
			.get("/assets/css/bootstrap.min.css"),
            http("request_8")
			.get("/assets/css/main.css")))
		.pause(9)
		.exec(http("request_9")
			.get("/computers?f=Slawetny123")
			.headers(headers_0)
			.resources(http("request_10")
			.get("/assets/css/bootstrap.min.css"),
            http("request_11")
			.get("/assets/css/main.css")))
		.pause(13)
		.exec(http("request_12")
			.get("/computers")
			.headers(headers_12)
			.resources(http("request_13")
			.get("/assets/css/bootstrap.min.css"),
            http("request_14")
			.get("/assets/css/main.css")))
		.pause(4)
		.exec(http("request_15")
			.get("/computers?p=1&n=10&s=name&d=asc")
			.headers(headers_0)
			.resources(http("request_16")
			.get("/assets/css/bootstrap.min.css"),
            http("request_17")
			.get("/assets/css/main.css")))
		.pause(2)
		.exec(http("request_18")
			.get("/computers?p=2&n=10&s=name&d=asc")
			.headers(headers_0))

	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}