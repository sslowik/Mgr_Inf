package anaplan

import java.io.{BufferedWriter, FileWriter}

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class LoginSim7 extends Simulation {

	val httpProtocol = http
		.baseUrl("https://us1a.app.anaplan.com")
		.acceptEncodingHeader("gzip, deflate")
		.acceptLanguageHeader("pl")
		.userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.193 Safari/537.36")

	val headers_0 = Map(
		"Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9",
		"Sec-Fetch-Dest" -> "document",
		"Sec-Fetch-Mode" -> "navigate",
		"Sec-Fetch-Site" -> "none",
		"Sec-Fetch-User" -> "?1",
		"Upgrade-Insecure-Requests" -> "1",
		"sec-ch-ua" -> """"Chromium";v="86", "\"Not\\A;Brand";v="99", "Google Chrome";v="86"""",
		"sec-ch-ua-mobile" -> "?0")

	val headers_1 = Map(
		"Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9",
		"Sec-Fetch-Dest" -> "document",
		"Sec-Fetch-Mode" -> "navigate",
		"Sec-Fetch-Site" -> "cross-site",
		"Sec-Fetch-User" -> "?1",
		"Upgrade-Insecure-Requests" -> "1",
		"sec-ch-ua" -> """"Chromium";v="86", "\"Not\\A;Brand";v="99", "Google Chrome";v="86"""",
		"sec-ch-ua-mobile" -> "?0")

	val headers_2 = Map(
		"Accept" -> "text/css,*/*;q=0.1",
		"Sec-Fetch-Dest" -> "style",
		"Sec-Fetch-Mode" -> "no-cors",
		"Sec-Fetch-Site" -> "same-origin",
		"sec-ch-ua" -> """"Chromium";v="86", "\"Not\\A;Brand";v="99", "Google Chrome";v="86"""",
		"sec-ch-ua-mobile" -> "?0")

	val headers_4 = Map(
		"Accept" -> "*/*",
		"Sec-Fetch-Dest" -> "script",
		"Sec-Fetch-Mode" -> "no-cors",
		"Sec-Fetch-Site" -> "same-origin",
		"sec-ch-ua" -> """"Chromium";v="86", "\"Not\\A;Brand";v="99", "Google Chrome";v="86"""",
		"sec-ch-ua-mobile" -> "?0")

	val headers_9 = Map(
		"Accept" -> "image/avif,image/webp,image/apng,image/*,*/*;q=0.8",
		"Sec-Fetch-Dest" -> "image",
		"Sec-Fetch-Mode" -> "no-cors",
		"Sec-Fetch-Site" -> "same-origin",
		"sec-ch-ua" -> """"Chromium";v="86", "\"Not\\A;Brand";v="99", "Google Chrome";v="86"""",
		"sec-ch-ua-mobile" -> "?0")

	val headers_11 = Map(
		"Accept" -> "*/*",
		"Origin" -> "https://fedauth.pg.com",
		"Sec-Fetch-Dest" -> "font",
		"Sec-Fetch-Mode" -> "cors",
		"Sec-Fetch-Site" -> "same-origin",
		"sec-ch-ua" -> """"Chromium";v="86", "\"Not\\A;Brand";v="99", "Google Chrome";v="86"""",
		"sec-ch-ua-mobile" -> "?0")

	val headers_13 = Map(
		"Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9",
		"Origin" -> "https://fedauth.pg.com",
		"Sec-Fetch-Dest" -> "document",
		"Sec-Fetch-Mode" -> "navigate",
		"Sec-Fetch-Site" -> "same-origin",
		"Sec-Fetch-User" -> "?1",
		"Upgrade-Insecure-Requests" -> "1",
		"sec-ch-ua" -> """"Chromium";v="86", "\"Not\\A;Brand";v="99", "Google Chrome";v="86"""",
		"sec-ch-ua-mobile" -> "?0")

	val headers_14 = Map(
		"Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9",
		"Origin" -> "https://fedauth.pg.com",
		"Sec-Fetch-Dest" -> "document",
		"Sec-Fetch-Mode" -> "navigate",
		"Sec-Fetch-Site" -> "cross-site",
		"Upgrade-Insecure-Requests" -> "1",
		"sec-ch-ua" -> """"Chromium";v="86", "\"Not\\A;Brand";v="99", "Google Chrome";v="86"""",
		"sec-ch-ua-mobile" -> "?0")

	val headers_15 = Map(
		"Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9",
		"Sec-Fetch-Dest" -> "document",
		"Sec-Fetch-Mode" -> "navigate",
		"Sec-Fetch-Site" -> "same-origin",
		"Upgrade-Insecure-Requests" -> "1",
		"sec-ch-ua" -> """"Chromium";v="86", "\"Not\\A;Brand";v="99", "Google Chrome";v="86"""",
		"sec-ch-ua-mobile" -> "?0")

	val headers_19 = Map(
		"Accept" -> "*/*",
		"Sec-Fetch-Dest" -> "empty",
		"Sec-Fetch-Mode" -> "cors",
		"Sec-Fetch-Site" -> "same-origin",
		"sec-ch-ua" -> """"Chromium";v="86", "\"Not\\A;Brand";v="99", "Google Chrome";v="86"""",
		"sec-ch-ua-mobile" -> "?0")

	val headers_20 = Map(
		"Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9",
		"Sec-Fetch-Dest" -> "iframe",
		"Sec-Fetch-Mode" -> "navigate",
		"Sec-Fetch-Site" -> "same-origin",
		"Upgrade-Insecure-Requests" -> "1",
		"sec-ch-ua" -> """"Chromium";v="86", "\"Not\\A;Brand";v="99", "Google Chrome";v="86"""",
		"sec-ch-ua-mobile" -> "?0")

	val headers_21 = Map(
		"Accept" -> "application/json",
		"Sec-Fetch-Dest" -> "empty",
		"Sec-Fetch-Mode" -> "cors",
		"Sec-Fetch-Site" -> "same-origin",
		"X-TracePath" -> "appshell",
		"sec-ch-ua" -> """"Chromium";v="86", "\"Not\\A;Brand";v="99", "Google Chrome";v="86"""",
		"sec-ch-ua-mobile" -> "?0")

	val headers_22 = Map(
		"Accept" -> "application/json",
		"Sec-Fetch-Dest" -> "empty",
		"Sec-Fetch-Mode" -> "cors",
		"Sec-Fetch-Site" -> "same-origin",
		"sec-ch-ua" -> """"Chromium";v="86", "\"Not\\A;Brand";v="99", "Google Chrome";v="86"""",
		"sec-ch-ua-mobile" -> "?0")

	val headers_27 = Map(
		"Accept" -> "application/json",
		"Content-Type" -> "application/json",
		"Origin" -> "https://us1a.app.anaplan.com",
		"Sec-Fetch-Dest" -> "empty",
		"Sec-Fetch-Mode" -> "cors",
		"Sec-Fetch-Site" -> "same-origin",
		"X-Client-Session-Id" -> "undefined",
		"X-TracePath" -> "home-web",
		"sec-ch-ua" -> """"Chromium";v="86", "\"Not\\A;Brand";v="99", "Google Chrome";v="86"""",
		"sec-ch-ua-mobile" -> "?0")

	val headers_28 = Map(
		"Accept" -> "application/json",
		"Content-Type" -> "application/json",
		"Sec-Fetch-Dest" -> "empty",
		"Sec-Fetch-Mode" -> "cors",
		"Sec-Fetch-Site" -> "same-origin",
		"X-Client-Session-Id" -> "0yN3nDzGV",
		"X-TracePath" -> "home-web",
		"sec-ch-ua" -> """"Chromium";v="86", "\"Not\\A;Brand";v="99", "Google Chrome";v="86"""",
		"sec-ch-ua-mobile" -> "?0")

	val headers_32 = Map(
		"Accept" -> "application/json",
		"Content-Type" -> "application/json",
		"Sec-Fetch-Dest" -> "empty",
		"Sec-Fetch-Mode" -> "cors",
		"Sec-Fetch-Site" -> "same-origin",
		"X-Client-Session-Id" -> "MCb0vsDoN",
		"X-TracePath" -> "home-web",
		"sec-ch-ua" -> """"Chromium";v="86", "\"Not\\A;Brand";v="99", "Google Chrome";v="86"""",
		"sec-ch-ua-mobile" -> "?0")

	val headers_37 = Map(
		"Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9",
		"Sec-Fetch-Dest" -> "document",
		"Sec-Fetch-Mode" -> "navigate",
		"Sec-Fetch-Site" -> "same-origin",
		"Sec-Fetch-User" -> "?1",
		"Upgrade-Insecure-Requests" -> "1",
		"sec-ch-ua" -> """"Chromium";v="86", "\"Not\\A;Brand";v="99", "Google Chrome";v="86"""",
		"sec-ch-ua-mobile" -> "?0")

	val headers_46 = Map(
		"Accept" -> "*/*",
		"Content-Type" -> "application/json",
		"Origin" -> "https://us1a.app.anaplan.com",
		"Request-Serial-Number" -> "FE2B3C5805094CC981CC15E513E0D41F-2",
		"Sec-Fetch-Dest" -> "empty",
		"Sec-Fetch-Mode" -> "cors",
		"Sec-Fetch-Site" -> "same-origin",
		"X-Auth-Token-Refresh" -> "no",
		"X-Requested-With" -> "XMLHttpRequest",
		"sec-ch-ua" -> """"Chromium";v="86", "\"Not\\A;Brand";v="99", "Google Chrome";v="86"""",
		"sec-ch-ua-mobile" -> "?0")

	val headers_47 = Map(
		"Accept" -> "*/*",
		"Content-Type" -> "application/json",
		"Origin" -> "https://us1a.app.anaplan.com",
		"Request-Serial-Number" -> "FE2B3C5805094CC981CC15E513E0D41F-1",
		"Sec-Fetch-Dest" -> "empty",
		"Sec-Fetch-Mode" -> "cors",
		"Sec-Fetch-Site" -> "same-origin",
		"X-Auth-Token-Refresh" -> "default",
		"X-Requested-With" -> "XMLHttpRequest",
		"sec-ch-ua" -> """"Chromium";v="86", "\"Not\\A;Brand";v="99", "Google Chrome";v="86"""",
		"sec-ch-ua-mobile" -> "?0")

	val headers_48 = Map(
		"Accept" -> "*/*",
		"Content-Type" -> "application/json",
		"Origin" -> "https://us1a.app.anaplan.com",
		"Request-Serial-Number" -> "FE2B3C5805094CC981CC15E513E0D41F-3",
		"Sec-Fetch-Dest" -> "empty",
		"Sec-Fetch-Mode" -> "cors",
		"Sec-Fetch-Site" -> "same-origin",
		"X-Auth-Token-Refresh" -> "default",
		"X-Requested-With" -> "XMLHttpRequest",
		"sec-ch-ua" -> """"Chromium";v="86", "\"Not\\A;Brand";v="99", "Google Chrome";v="86"""",
		"sec-ch-ua-mobile" -> "?0")

	val headers_51 = Map(
		"Accept" -> "*/*",
		"Content-Type" -> "application/json",
		"Origin" -> "https://us1a.app.anaplan.com",
		"Request-Serial-Number" -> "FE2B3C5805094CC981CC15E513E0D41F-4",
		"Sec-Fetch-Dest" -> "empty",
		"Sec-Fetch-Mode" -> "cors",
		"Sec-Fetch-Site" -> "same-origin",
		"X-Auth-Token-Refresh" -> "default",
		"X-Requested-With" -> "XMLHttpRequest",
		"sec-ch-ua" -> """"Chromium";v="86", "\"Not\\A;Brand";v="99", "Google Chrome";v="86"""",
		"sec-ch-ua-mobile" -> "?0")

	val headers_52 = Map(
		"Accept" -> "application/json, text/plain, */*",
		"Sec-Fetch-Dest" -> "empty",
		"Sec-Fetch-Mode" -> "cors",
		"Sec-Fetch-Site" -> "same-origin",
		"sec-ch-ua" -> """"Chromium";v="86", "\"Not\\A;Brand";v="99", "Google Chrome";v="86"""",
		"sec-ch-ua-mobile" -> "?0")

	val headers_53 = Map(
		"Accept" -> "*/*",
		"Content-Type" -> "application/json",
		"Origin" -> "https://us1a.app.anaplan.com",
		"Sec-Fetch-Dest" -> "empty",
		"Sec-Fetch-Mode" -> "cors",
		"Sec-Fetch-Site" -> "same-origin",
		"sec-ch-ua" -> """"Chromium";v="86", "\"Not\\A;Brand";v="99", "Google Chrome";v="86"""",
		"sec-ch-ua-mobile" -> "?0")

	val headers_56 = Map(
		"Accept" -> "*/*",
		"Content-Type" -> "application/json",
		"Origin" -> "https://us1a.app.anaplan.com",
		"Request-Serial-Number" -> "FE2B3C5805094CC981CC15E513E0D41F-5",
		"Sec-Fetch-Dest" -> "empty",
		"Sec-Fetch-Mode" -> "cors",
		"Sec-Fetch-Site" -> "same-origin",
		"X-Auth-Token-Refresh" -> "default",
		"X-Requested-With" -> "XMLHttpRequest",
		"sec-ch-ua" -> """"Chromium";v="86", "\"Not\\A;Brand";v="99", "Google Chrome";v="86"""",
		"sec-ch-ua-mobile" -> "?0")

	val headers_57 = Map(
		"Accept" -> "*/*",
		"Content-Type" -> "application/json",
		"Origin" -> "https://us1a.app.anaplan.com",
		"Request-Serial-Number" -> "FE2B3C5805094CC981CC15E513E0D41F-6",
		"Sec-Fetch-Dest" -> "empty",
		"Sec-Fetch-Mode" -> "cors",
		"Sec-Fetch-Site" -> "same-origin",
		"X-Auth-Token-Refresh" -> "default",
		"X-Requested-With" -> "XMLHttpRequest",
		"sec-ch-ua" -> """"Chromium";v="86", "\"Not\\A;Brand";v="99", "Google Chrome";v="86"""",
		"sec-ch-ua-mobile" -> "?0")

	val headers_59 = Map(
		"Accept" -> "*/*",
		"Content-Type" -> "application/json",
		"Origin" -> "https://us1a.app.anaplan.com",
		"Request-Serial-Number" -> "FE2B3C5805094CC981CC15E513E0D41F-7",
		"Sec-Fetch-Dest" -> "empty",
		"Sec-Fetch-Mode" -> "cors",
		"Sec-Fetch-Site" -> "same-origin",
		"X-Auth-Token-Refresh" -> "default",
		"X-Requested-With" -> "XMLHttpRequest",
		"sec-ch-ua" -> """"Chromium";v="86", "\"Not\\A;Brand";v="99", "Google Chrome";v="86"""",
		"sec-ch-ua-mobile" -> "?0")

	val headers_61 = Map(
		"Accept" -> "*/*",
		"Content-Type" -> "application/json",
		"Origin" -> "https://us1a.app.anaplan.com",
		"Request-Serial-Number" -> "FE2B3C5805094CC981CC15E513E0D41F-8",
		"Sec-Fetch-Dest" -> "empty",
		"Sec-Fetch-Mode" -> "cors",
		"Sec-Fetch-Site" -> "same-origin",
		"X-Auth-Token-Refresh" -> "default",
		"X-Requested-With" -> "XMLHttpRequest",
		"sec-ch-ua" -> """"Chromium";v="86", "\"Not\\A;Brand";v="99", "Google Chrome";v="86"""",
		"sec-ch-ua-mobile" -> "?0")

	val headers_62 = Map(
		"Accept" -> "*/*",
		"Content-Type" -> "application/json",
		"Origin" -> "https://us1a.app.anaplan.com",
		"Request-Serial-Number" -> "FE2B3C5805094CC981CC15E513E0D41F-9",
		"Sec-Fetch-Dest" -> "empty",
		"Sec-Fetch-Mode" -> "cors",
		"Sec-Fetch-Site" -> "same-origin",
		"X-Auth-Token-Refresh" -> "default",
		"X-Requested-With" -> "XMLHttpRequest",
		"sec-ch-ua" -> """"Chromium";v="86", "\"Not\\A;Brand";v="99", "Google Chrome";v="86"""",
		"sec-ch-ua-mobile" -> "?0")

	val headers_66 = Map(
		"Accept-Encoding" -> "gzip, deflate",
		"Pragma" -> "no-cache",
		"Proxy-Connection" -> "keep-alive")

	val headers_67 = Map(
		"Accept" -> "*/*",
		"Content-Type" -> "application/json",
		"Origin" -> "https://us1a.app.anaplan.com",
		"Request-Serial-Number" -> "FE2B3C5805094CC981CC15E513E0D41F-10",
		"Sec-Fetch-Dest" -> "empty",
		"Sec-Fetch-Mode" -> "cors",
		"Sec-Fetch-Site" -> "same-origin",
		"X-Auth-Token-Refresh" -> "default",
		"X-Requested-With" -> "XMLHttpRequest",
		"sec-ch-ua" -> """"Chromium";v="86", "\"Not\\A;Brand";v="99", "Google Chrome";v="86"""",
		"sec-ch-ua-mobile" -> "?0")

	val headers_68 = Map(
		"Accept" -> "*/*",
		"Content-Type" -> "application/json",
		"Origin" -> "https://us1a.app.anaplan.com",
		"Request-Serial-Number" -> "FE2B3C5805094CC981CC15E513E0D41F-11",
		"Sec-Fetch-Dest" -> "empty",
		"Sec-Fetch-Mode" -> "cors",
		"Sec-Fetch-Site" -> "same-origin",
		"X-Auth-Token-Refresh" -> "default",
		"X-Requested-With" -> "XMLHttpRequest",
		"sec-ch-ua" -> """"Chromium";v="86", "\"Not\\A;Brand";v="99", "Google Chrome";v="86"""",
		"sec-ch-ua-mobile" -> "?0")

	val headers_70 = Map(
		"Accept" -> "*/*",
		"Content-Type" -> "application/json",
		"Origin" -> "https://us1a.app.anaplan.com",
		"Request-Serial-Number" -> "FE2B3C5805094CC981CC15E513E0D41F-12",
		"Sec-Fetch-Dest" -> "empty",
		"Sec-Fetch-Mode" -> "cors",
		"Sec-Fetch-Site" -> "same-origin",
		"X-Auth-Token-Refresh" -> "default",
		"X-Requested-With" -> "XMLHttpRequest",
		"sec-ch-ua" -> """"Chromium";v="86", "\"Not\\A;Brand";v="99", "Google Chrome";v="86"""",
		"sec-ch-ua-mobile" -> "?0")

	val headers_71 = Map(
		"Accept" -> "*/*",
		"Content-Type" -> "application/json",
		"Origin" -> "https://us1a.app.anaplan.com",
		"Request-Serial-Number" -> "FE2B3C5805094CC981CC15E513E0D41F-13",
		"Sec-Fetch-Dest" -> "empty",
		"Sec-Fetch-Mode" -> "cors",
		"Sec-Fetch-Site" -> "same-origin",
		"X-Auth-Token-Refresh" -> "default",
		"X-Requested-With" -> "XMLHttpRequest",
		"sec-ch-ua" -> """"Chromium";v="86", "\"Not\\A;Brand";v="99", "Google Chrome";v="86"""",
		"sec-ch-ua-mobile" -> "?0")

	val headers_73 = Map(
		"Accept" -> "*/*",
		"Content-Type" -> "application/json",
		"Expect-Reply-Within" -> "10; workspaceServerGuid=6AF159BF36EA44DAABE4006A395C5A6E userGuid=8a81b013706ef34601709bc23f617f21",
		"Origin" -> "https://us1a.app.anaplan.com",
		"Sec-Fetch-Dest" -> "empty",
		"Sec-Fetch-Mode" -> "cors",
		"Sec-Fetch-Site" -> "same-origin",
		"X-Requested-With" -> "XMLHttpRequest",
		"sec-ch-ua" -> """"Chromium";v="86", "\"Not\\A;Brand";v="99", "Google Chrome";v="86"""",
		"sec-ch-ua-mobile" -> "?0")

	val headers_74 = Map(
		"Accept" -> "*/*",
		"Content-Type" -> "application/json",
		"Origin" -> "https://us1a.app.anaplan.com",
		"Request-Serial-Number" -> "FE2B3C5805094CC981CC15E513E0D41F-14",
		"Sec-Fetch-Dest" -> "empty",
		"Sec-Fetch-Mode" -> "cors",
		"Sec-Fetch-Site" -> "same-origin",
		"X-Auth-Token-Refresh" -> "default",
		"X-Requested-With" -> "XMLHttpRequest",
		"sec-ch-ua" -> """"Chromium";v="86", "\"Not\\A;Brand";v="99", "Google Chrome";v="86"""",
		"sec-ch-ua-mobile" -> "?0")

	val headers_76 = Map(
		"Accept" -> "*/*",
		"Content-Type" -> "application/json",
		"Origin" -> "https://us1a.app.anaplan.com",
		"Request-Serial-Number" -> "FE2B3C5805094CC981CC15E513E0D41F-15",
		"Sec-Fetch-Dest" -> "empty",
		"Sec-Fetch-Mode" -> "cors",
		"Sec-Fetch-Site" -> "same-origin",
		"X-Auth-Token-Refresh" -> "default",
		"X-Requested-With" -> "XMLHttpRequest",
		"sec-ch-ua" -> """"Chromium";v="86", "\"Not\\A;Brand";v="99", "Google Chrome";v="86"""",
		"sec-ch-ua-mobile" -> "?0")

	val headers_77 = Map(
		"Accept" -> "*/*",
		"Content-Type" -> "application/json",
		"Origin" -> "https://us1a.app.anaplan.com",
		"Request-Serial-Number" -> "FE2B3C5805094CC981CC15E513E0D41F-16",
		"Sec-Fetch-Dest" -> "empty",
		"Sec-Fetch-Mode" -> "cors",
		"Sec-Fetch-Site" -> "same-origin",
		"X-Auth-Token-Refresh" -> "default",
		"X-Requested-With" -> "XMLHttpRequest",
		"sec-ch-ua" -> """"Chromium";v="86", "\"Not\\A;Brand";v="99", "Google Chrome";v="86"""",
		"sec-ch-ua-mobile" -> "?0")

	val headers_78 = Map(
		"Accept" -> "*/*",
		"Content-Type" -> "application/json",
		"Origin" -> "https://us1a.app.anaplan.com",
		"Request-Serial-Number" -> "FE2B3C5805094CC981CC15E513E0D41F-17",
		"Sec-Fetch-Dest" -> "empty",
		"Sec-Fetch-Mode" -> "cors",
		"Sec-Fetch-Site" -> "same-origin",
		"X-Auth-Token-Refresh" -> "no",
		"X-Requested-With" -> "XMLHttpRequest",
		"sec-ch-ua" -> """"Chromium";v="86", "\"Not\\A;Brand";v="99", "Google Chrome";v="86"""",
		"sec-ch-ua-mobile" -> "?0")

	val headers_80 = Map(
		"Accept" -> "*/*",
		"Content-Type" -> "application/json",
		"Origin" -> "https://us1a.app.anaplan.com",
		"Request-Serial-Number" -> "FE2B3C5805094CC981CC15E513E0D41F-18",
		"Sec-Fetch-Dest" -> "empty",
		"Sec-Fetch-Mode" -> "cors",
		"Sec-Fetch-Site" -> "same-origin",
		"X-Auth-Token-Refresh" -> "default",
		"X-Requested-With" -> "XMLHttpRequest",
		"sec-ch-ua" -> """"Chromium";v="86", "\"Not\\A;Brand";v="99", "Google Chrome";v="86"""",
		"sec-ch-ua-mobile" -> "?0")

	val headers_81 = Map(
		"Accept" -> "*/*",
		"Content-Type" -> "application/json",
		"Origin" -> "https://us1a.app.anaplan.com",
		"Request-Serial-Number" -> "FE2B3C5805094CC981CC15E513E0D41F-19",
		"Sec-Fetch-Dest" -> "empty",
		"Sec-Fetch-Mode" -> "cors",
		"Sec-Fetch-Site" -> "same-origin",
		"X-Auth-Token-Refresh" -> "no",
		"X-Requested-With" -> "XMLHttpRequest",
		"sec-ch-ua" -> """"Chromium";v="86", "\"Not\\A;Brand";v="99", "Google Chrome";v="86"""",
		"sec-ch-ua-mobile" -> "?0")

	val headers_82 = Map(
		"Accept" -> "*/*",
		"Content-Type" -> "application/json",
		"Origin" -> "https://us1a.app.anaplan.com",
		"Request-Serial-Number" -> "FE2B3C5805094CC981CC15E513E0D41F-21",
		"Sec-Fetch-Dest" -> "empty",
		"Sec-Fetch-Mode" -> "cors",
		"Sec-Fetch-Site" -> "same-origin",
		"X-Auth-Token-Refresh" -> "no",
		"X-Requested-With" -> "XMLHttpRequest",
		"sec-ch-ua" -> """"Chromium";v="86", "\"Not\\A;Brand";v="99", "Google Chrome";v="86"""",
		"sec-ch-ua-mobile" -> "?0")

	val headers_83 = Map(
		"Accept" -> "*/*",
		"Content-Type" -> "application/json",
		"Origin" -> "https://us1a.app.anaplan.com",
		"Request-Serial-Number" -> "FE2B3C5805094CC981CC15E513E0D41F-20",
		"Sec-Fetch-Dest" -> "empty",
		"Sec-Fetch-Mode" -> "cors",
		"Sec-Fetch-Site" -> "same-origin",
		"X-Auth-Token-Refresh" -> "default",
		"X-Requested-With" -> "XMLHttpRequest",
		"sec-ch-ua" -> """"Chromium";v="86", "\"Not\\A;Brand";v="99", "Google Chrome";v="86"""",
		"sec-ch-ua-mobile" -> "?0")

	val headers_84 = Map(
		"Accept" -> "*/*",
		"Content-Type" -> "application/json",
		"Origin" -> "https://us1a.app.anaplan.com",
		"Request-Serial-Number" -> "FE2B3C5805094CC981CC15E513E0D41F-22",
		"Sec-Fetch-Dest" -> "empty",
		"Sec-Fetch-Mode" -> "cors",
		"Sec-Fetch-Site" -> "same-origin",
		"X-Auth-Token-Refresh" -> "default",
		"X-Requested-With" -> "XMLHttpRequest",
		"sec-ch-ua" -> """"Chromium";v="86", "\"Not\\A;Brand";v="99", "Google Chrome";v="86"""",
		"sec-ch-ua-mobile" -> "?0")

	val headers_85 = Map(
		"Accept" -> "*/*",
		"Content-Type" -> "application/json",
		"Origin" -> "https://us1a.app.anaplan.com",
		"Request-Serial-Number" -> "FE2B3C5805094CC981CC15E513E0D41F-23",
		"Sec-Fetch-Dest" -> "empty",
		"Sec-Fetch-Mode" -> "cors",
		"Sec-Fetch-Site" -> "same-origin",
		"X-Auth-Token-Refresh" -> "default",
		"X-Requested-With" -> "XMLHttpRequest",
		"sec-ch-ua" -> """"Chromium";v="86", "\"Not\\A;Brand";v="99", "Google Chrome";v="86"""",
		"sec-ch-ua-mobile" -> "?0")

	val headers_87 = Map(
		"Accept" -> "*/*",
		"Content-Type" -> "application/json",
		"Origin" -> "https://us1a.app.anaplan.com",
		"Request-Serial-Number" -> "FE2B3C5805094CC981CC15E513E0D41F-24",
		"Sec-Fetch-Dest" -> "empty",
		"Sec-Fetch-Mode" -> "cors",
		"Sec-Fetch-Site" -> "same-origin",
		"X-Auth-Token-Refresh" -> "default",
		"X-Requested-With" -> "XMLHttpRequest",
		"sec-ch-ua" -> """"Chromium";v="86", "\"Not\\A;Brand";v="99", "Google Chrome";v="86"""",
		"sec-ch-ua-mobile" -> "?0")

	val headers_88 = Map(
		"Accept" -> "*/*",
		"Content-Type" -> "application/json",
		"Origin" -> "https://us1a.app.anaplan.com",
		"Request-Serial-Number" -> "FE2B3C5805094CC981CC15E513E0D41F-25",
		"Sec-Fetch-Dest" -> "empty",
		"Sec-Fetch-Mode" -> "cors",
		"Sec-Fetch-Site" -> "same-origin",
		"X-Auth-Token-Refresh" -> "default",
		"X-Requested-With" -> "XMLHttpRequest",
		"sec-ch-ua" -> """"Chromium";v="86", "\"Not\\A;Brand";v="99", "Google Chrome";v="86"""",
		"sec-ch-ua-mobile" -> "?0")

	val headers_89 = Map(
		"Accept" -> "*/*",
		"Content-Type" -> "application/json",
		"Origin" -> "https://us1a.app.anaplan.com",
		"Request-Serial-Number" -> "FE2B3C5805094CC981CC15E513E0D41F-26",
		"Sec-Fetch-Dest" -> "empty",
		"Sec-Fetch-Mode" -> "cors",
		"Sec-Fetch-Site" -> "same-origin",
		"X-Auth-Token-Refresh" -> "default",
		"X-Requested-With" -> "XMLHttpRequest",
		"sec-ch-ua" -> """"Chromium";v="86", "\"Not\\A;Brand";v="99", "Google Chrome";v="86"""",
		"sec-ch-ua-mobile" -> "?0")

	val headers_90 = Map(
		"Accept" -> "*/*",
		"Content-Type" -> "application/json",
		"Origin" -> "https://us1a.app.anaplan.com",
		"Request-Serial-Number" -> "FE2B3C5805094CC981CC15E513E0D41F-28",
		"Sec-Fetch-Dest" -> "empty",
		"Sec-Fetch-Mode" -> "cors",
		"Sec-Fetch-Site" -> "same-origin",
		"X-Auth-Token-Refresh" -> "no",
		"X-Requested-With" -> "XMLHttpRequest",
		"sec-ch-ua" -> """"Chromium";v="86", "\"Not\\A;Brand";v="99", "Google Chrome";v="86"""",
		"sec-ch-ua-mobile" -> "?0")

	val headers_91 = Map(
		"Accept" -> "*/*",
		"Content-Type" -> "application/json",
		"Origin" -> "https://us1a.app.anaplan.com",
		"Request-Serial-Number" -> "FE2B3C5805094CC981CC15E513E0D41F-27",
		"Sec-Fetch-Dest" -> "empty",
		"Sec-Fetch-Mode" -> "cors",
		"Sec-Fetch-Site" -> "same-origin",
		"X-Auth-Token-Refresh" -> "default",
		"X-Requested-With" -> "XMLHttpRequest",
		"sec-ch-ua" -> """"Chromium";v="86", "\"Not\\A;Brand";v="99", "Google Chrome";v="86"""",
		"sec-ch-ua-mobile" -> "?0")

	val headers_92 = Map(
		"Accept" -> "*/*",
		"Content-Type" -> "application/json",
		"Origin" -> "https://us1a.app.anaplan.com",
		"Request-Serial-Number" -> "FE2B3C5805094CC981CC15E513E0D41F-29",
		"Sec-Fetch-Dest" -> "empty",
		"Sec-Fetch-Mode" -> "cors",
		"Sec-Fetch-Site" -> "same-origin",
		"X-Auth-Token-Refresh" -> "default",
		"X-Requested-With" -> "XMLHttpRequest",
		"sec-ch-ua" -> """"Chromium";v="86", "\"Not\\A;Brand";v="99", "Google Chrome";v="86"""",
		"sec-ch-ua-mobile" -> "?0")

	val headers_93 = Map(
		"Accept" -> "*/*",
		"Content-Type" -> "application/json",
		"Origin" -> "https://us1a.app.anaplan.com",
		"Request-Serial-Number" -> "FE2B3C5805094CC981CC15E513E0D41F-30",
		"Sec-Fetch-Dest" -> "empty",
		"Sec-Fetch-Mode" -> "cors",
		"Sec-Fetch-Site" -> "same-origin",
		"X-Auth-Token-Refresh" -> "default",
		"X-Requested-With" -> "XMLHttpRequest",
		"sec-ch-ua" -> """"Chromium";v="86", "\"Not\\A;Brand";v="99", "Google Chrome";v="86"""",
		"sec-ch-ua-mobile" -> "?0")

    val uri2 = "https://fedauth.pg.com"
    val uri3 = "https://sdp.anaplan.com/frontdoor"
    val uri4 = "http://www.gstatic.com/generate_204"

	val chain_0 = exec(http("request_0")
			.get(uri3 + "/saml/pgfedsaml")
			.headers(headers_0))
		.pause(8)
		.exec(http("request_1")
			.get(uri2 + "/idp/SSO.saml2?SAMLRequest=jVNLa%2BMwEP4rRnc%2FSdwgYpdsStlCl4bY3UMvRZEmqcCWtBo5m5%2B%2Fsh1TH7YlN6OZb74XXt9f2iY4g0WpVUHSKCEBKK6FVKeCvNaP4Yrcl2tkbWPopnMfag9%2FOkAXeJxCOgwK0llFNUOJVLEWkDpOq82vZ5pFCTVWO811Q4INIljnibZaYdeCrcCeJYfX%2FXNBPpwzSOMYhYmYYqZhKuK6jY9WKye0tnHPFZvTEUT%2FRYIHL0Mq5gblE9xPmZcZmdOAlsLEVfUS9YiMBI%2FachhsFOTIGgQSPD0U5D1l%2BWKxzEWY3i0Pd3mSHTIRLhOe%2BznuGKI8wycCsYMnhY4pV5AsyZIwTcM0q9OEpjldptFitXojwe5q%2FIdUY5zfpXQYl5D%2BrOtduHupahL8nmrxC2QqYWC3t8fPptBJ%2BUXE63h%2BeeTJDL0WDWLIy1fm4DKvPbu5961uDbMSeytwYdxdzdD55W3jle7hOGO42di3a5zy%2FrR%2F7ov8q63oiwHundWWKTTaujGC%2F%2Bopx9lXgZRTevOfo%2FwH")
			.headers(headers_1))
		.exec(http("request_2")
			.get(uri2 + "/assets/css/googlefont.css")
			.headers(headers_2))
		.exec(http("request_3")
			.get(uri2 + "/assets/css/pg.prof.main.css")
			.headers(headers_2))
		.exec(http("request_4")
			.get(uri2 + "/assets/js/ladda.min.js")
			.headers(headers_4))
		.exec(http("request_5")
			.get(uri2 + "/assets/css/tmx.css")
			.headers(headers_2))
		.exec(http("request_6")
			.get(uri2 + "/assets/css/ladda-themeless.min.css")
			.headers(headers_2))
		.exec(http("request_7")
			.get(uri2 + "/assets/js/threatmetrix-1.0.js")
			.headers(headers_4))
		.exec(http("request_8")
			.get(uri2 + "/assets/js/spin.min.js")
			.headers(headers_4))
		.exec(http("request_9")
			.get(uri2 + "/assets/images/pg_logo_u13.png")
			.headers(headers_9))
		.exec(http("request_10")
			.get(uri2 + "/assets/js/jquery-2.2.0.min.js")
			.headers(headers_4))
		.exec(http("request_11")
			.get(uri2 + "/assets/fonts/proxima-nova/mem8YaGs126MiZpBA-UFVZ0b.woff2")
			.headers(headers_11))
		.exec(http("request_12")
			.get(uri2 + "/assets/fonts/proxima-nova/mem5YaGs126MiZpBA-UN7rgOUuhp.woff2")
			.headers(headers_11))
		.pause(10)
		.exec(http("request_13")
			.post(uri2 + "/idp/Qgpc9/resumeSAML20/idp/SSO.ping")
			.headers(headers_13)
			.formParam("pf.username", "tisanaplanuseruat.im")
			.formParam("pf.pass", "Osmiornica2/")
			.formParam("pf.ok", "clicked")
			.formParam("pf.adapterId", "PGEDFormAdapter")
            .check(headerRegex("Set-Cookie", "X-Auth-Token=(.*)").saveAs("auth_token"))
        )
        .exec {
            session =>
            val fw = new BufferedWriter(new FileWriter("auth_token.txt", true))
            try {
            fw.write(session("auth_token").as[String] + "\r\n")
            }
            finally fw.close()
            session
        }
    // .check(jsonPath("$.access_token").saveAs("access_token")))
		
	val scn = scenario("RecordedSimulation1").exec(chain_0)

	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}