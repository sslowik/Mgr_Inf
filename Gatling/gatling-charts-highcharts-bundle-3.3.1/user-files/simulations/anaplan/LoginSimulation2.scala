package anaplan

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class LoginSimulation2 extends Simulation {

    val uri1 = "https://us1a.app.anaplan.com"
    val uri2 = "https://fedauth.pg.com"
    val uri3 = "https://sdp.anaplan.com/frontdoor"
    val uri4 = "http://www.gstatic.com/generate_204"

    val httpProtocol = http
		.baseUrl(uri1)
		.acceptEncodingHeader("gzip, deflate")
		.acceptLanguageHeader("pl")
		.userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.193 Safari/537.36")
    
    val sessionHeaders = Map("Authorization" -> "Bearer ${authToken}",
                           "Content-Type" -> "application/json")

	val headers_login = Map(
		"Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9",
		"Origin" -> "https://fedauth.pg.com",
		"Sec-Fetch-Dest" -> "document",
		"Sec-Fetch-Mode" -> "navigate",
		"Sec-Fetch-Site" -> "same-origin",
		"Sec-Fetch-User" -> "?1",
		"Upgrade-Insecure-Requests" -> "1",
		"sec-ch-ua" -> """"Chromium";v="86", "\"Not\\A;Brand";v="99", "Google Chrome";v="86"""",
		"sec-ch-ua-mobile" -> "?0")

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

	val scn = scenario("login_test")
		exec(http("request_0")
			.get(uri3 + "/saml/pgfedsaml")
			.headers(headers_0))
		.pause(8)
		.exec(http("request_1")
			.get(uri2 + "/idp/SSO.saml2?SAMLRequest=jVNLa%2BMwEP4rRnc%2FSdwgYpdsStlCl4bY3UMvRZEmqcCWtBo5m5%2B%2Fsh1TH7YlN6OZb74XXt9f2iY4g0WpVUHSKCEBKK6FVKeCvNaP4Yrcl2tkbWPopnMfag9%2FOkAXeJxCOgwK0llFNUOJVLEWkDpOq82vZ5pFCTVWO811Q4INIljnibZaYdeCrcCeJYfX%2FXNBPpwzSOMYhYmYYqZhKuK6jY9WKye0tnHPFZvTEUT%2FRYIHL0Mq5gblE9xPmZcZmdOAlsLEVfUS9YiMBI%2FachhsFOTIGgQSPD0U5D1l%2BWKxzEWY3i0Pd3mSHTIRLhOe%2BznuGKI8wycCsYMnhY4pV5AsyZIwTcM0q9OEpjldptFitXojwe5q%2FIdUY5zfpXQYl5D%2BrOtduHupahL8nmrxC2QqYWC3t8fPptBJ%2BUXE63h%2BeeTJDL0WDWLIy1fm4DKvPbu5961uDbMSeytwYdxdzdD55W3jle7hOGO42di3a5zy%2FrR%2F7ov8q63oiwHundWWKTTaujGC%2F%2Bopx9lXgZRTevOfo%2FwH")
			.headers(headers_1))
		.exec(http("request_login")
			.post(uri2 + "/idp/Qgpc9/resumeSAML20/idp/SSO.ping")
			.headers(headers_login)
			.formParam("pf.username", "tisanaplanuseruat.im")
			.formParam("pf.pass", "Osmiornica2/")
			.formParam("pf.ok", "clicked")
			.formParam("pf.adapterId", "PGEDFormAdapter"))
		.exec(http("request_14")
			.post(uri3 + "/saml/pgfedsaml")
			.headers(headers_14)
			.formParam("SAMLResponse", "PHNhbWxwOlJlc3BvbnNlIFZlcnNpb249IjIuMCIgSUQ9IldDa0VZZ2VlcmdUaDYwTHdGVW9KMWUwVnFoOSIgSXNzdWVJbnN0YW50PSIyMDIwLTExLTEyVDEwOjE3OjI5LjMxNVoiIEluUmVzcG9uc2VUbz0iXzFhNjQ0NTZkLTE3NWI3NjAyYjJkLTUwYzYiIERlc3RpbmF0aW9uPSJodHRwczovL3NkcC5hbmFwbGFuLmNvbS9mcm9udGRvb3Ivc2FtbC9wZ2ZlZHNhbWwiIHhtbG5zOnNhbWxwPSJ1cm46b2FzaXM6bmFtZXM6dGM6U0FNTDoyLjA6cHJvdG9jb2wiPjxzYW1sOklzc3VlciB4bWxuczpzYW1sPSJ1cm46b2FzaXM6bmFtZXM6dGM6U0FNTDoyLjA6YXNzZXJ0aW9uIj5odHRwczovL2ZlZGF1dGgucGcuY29tPC9zYW1sOklzc3Vlcj48ZHM6U2lnbmF0dXJlIHhtbG5zOmRzPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwLzA5L3htbGRzaWcjIj48ZHM6U2lnbmVkSW5mbz48ZHM6Q2Fub25pY2FsaXphdGlvbk1ldGhvZCBBbGdvcml0aG09Imh0dHA6Ly93d3cudzMub3JnLzIwMDEvMTAveG1sLWV4Yy1jMTRuIyIvPjxkczpTaWduYXR1cmVNZXRob2QgQWxnb3JpdGhtPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwLzA5L3htbGRzaWcjcnNhLXNoYTEiLz48ZHM6UmVmZXJlbmNlIFVSST0iI1dDa0VZZ2VlcmdUaDYwTHdGVW9KMWUwVnFoOSI+PGRzOlRyYW5zZm9ybXM+PGRzOlRyYW5zZm9ybSBBbGdvcml0aG09Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvMDkveG1sZHNpZyNlbnZlbG9wZWQtc2lnbmF0dXJlIi8+PGRzOlRyYW5zZm9ybSBBbGdvcml0aG09Imh0dHA6Ly93d3cudzMub3JnLzIwMDEvMTAveG1sLWV4Yy1jMTRuIyIvPjwvZHM6VHJhbnNmb3Jtcz48ZHM6RGlnZXN0TWV0aG9kIEFsZ29yaXRobT0iaHR0cDovL3d3dy53My5vcmcvMjAwMC8wOS94bWxkc2lnI3NoYTEiLz48ZHM6RGlnZXN0VmFsdWU+b01DUHdYTzJrNTJteENDN091SGtmS0N0WXd3PTwvZHM6RGlnZXN0VmFsdWU+PC9kczpSZWZlcmVuY2U+PC9kczpTaWduZWRJbmZvPjxkczpTaWduYXR1cmVWYWx1ZT54akY5dU5nU2FpdHNwdERObDVuZmRmVEozTGhHYnBPZi9Wdll0bitJSmRva1JHWUt4OVJIdHk3MG9PQjhuaWJITmlJbENva0w2aHJySTFqRmJHdXNXWU5ZQVdFSzRRZ1NSekRIVldoWC9jSTNHd295dWZQdzE5R3NmMDVEVkJhTk1xTGFWb3FKbnFZTlNqMGtYR3VRR2N3S2U3SlF5ME4zVDBVb0pTMGlPdzZHcDlGekxVbFE0dmIxTDJhRHoxdjQyclZrYTYxVm9kWHpBSGZRUXZvSVB5UldPN3p1QjF5M241M1NxKzFtSVoyWmgxMVR1WFdCcVFFM3Y1M01OZjBYU2pNUExoUWppZEl4dGtBMmNxZ1FlZkM1ZU90UTBRd2ZmMFBuU1BDQU1MeWRBR3FjSk5SVDRsWHZnMFp3eEthY1Y1b01KWUl2ZTREY2lrSmFvbVZIOHc9PTwvZHM6U2lnbmF0dXJlVmFsdWU+PGRzOktleUluZm8+PGRzOlg1MDlEYXRhPjxkczpYNTA5Q2VydGlmaWNhdGU+TUlJSE5EQ0NCaHlnQXdJQkFnSVFOVTIycGtvbVVCSUFBQUFBVVFGcmhUQU5CZ2txaGtpRzl3MEJBUXNGQURDQnVqRUxNQWtHQTFVRUJoTUNWVk14RmpBVUJnTlZCQW9URFVWdWRISjFjM1FzSUVsdVl5NHhLREFtQmdOVkJBc1RIMU5sWlNCM2QzY3VaVzUwY25WemRDNXVaWFF2YkdWbllXd3RkR1Z5YlhNeE9UQTNCZ05WQkFzVE1DaGpLU0F5TURFeUlFVnVkSEoxYzNRc0lFbHVZeTRnTFNCbWIzSWdZWFYwYUc5eWFYcGxaQ0IxYzJVZ2IyNXNlVEV1TUN3R0ExVUVBeE1sUlc1MGNuVnpkQ0JEWlhKMGFXWnBZMkYwYVc5dUlFRjFkR2h2Y21sMGVTQXRJRXd4U3pBZUZ3MHlNREF6TWpZd09UVTFNemxhRncweU1qQXpNalV4TURJMU16bGFNRzh4Q3pBSkJnTlZCQVlUQWxWVE1RMHdDd1lEVlFRSUV3UlBhR2x2TVJNd0VRWURWUVFIRXdwRGFXNWphVzV1WVhScE1TTXdJUVlEVlFRS0V4cFVhR1VnVUhKdlkzUmxjaUJoYm1RZ1IyRnRZbXhsSUVOdkxqRVhNQlVHQTFVRUF4TU9abVZrWVhWMGFDNXdaeTVqYjIwd2dnRWlNQTBHQ1NxR1NJYjNEUUVCQVFVQUE0SUJEd0F3Z2dFS0FvSUJBUURHK29OeUw4UWtQRGYrTmR5aHV5RzFCcWtQTzYya1dTaWhqVHNqRVBIQmwyL1B2ZlJ2ZlFWVlNvSUU5VU9YaHJqKzRpT05NQThVSGJjM2NMa0pidlhJMElEOEpwaE1EUVYrdVg3amlERTBSZThwQ05KbUpUTUgrYmIzV2gzRkdLdktLVi9YSFc5dDRYdUFPSnFmV0RJWEFqRm42ZGVKTEkvcmtWamozSllPOWFDdUwrOXNvODZ0Q0FHR3NVbk1veDVxZGZoaE9HRWQ0YzBHalNxRGtxdmdpZXZoQTNQbzlPSVozbUpRaGRYRHdrRlVadktzRUlyWjBjQUNEZzlZejBxWHVWdWUvS0x2T3ZMbmx3VFluOTJTOWpCTkFXV25JSzZUOU1jTDU2aHJ0ZFovS21VeWQxQmNLblpjUGUvL3hoR0hVN25mdCtveW1XeXhuOCtvZkNxQkFnTUJBQUdqZ2dOK01JSURlakFaQmdOVkhSRUVFakFRZ2c1bVpXUmhkWFJvTG5CbkxtTnZiVENDQWZVR0Npc0dBUVFCMW5rQ0JBSUVnZ0hsQklJQjRRSGZBSFVBVllIVXdoYVFOZ0ZLNmd1YlZ6eFQ4TURrT0hod0pRZ1hMNk9xSFFjVDB3d0FBQUZ4Rm1CSGhBQUFCQU1BUmpCRUFpQlZraU54Tk1mdk1lemxJNVdrcFJCVUZCQ2hBWGxYZnBNYjgzaC8rRVA0UHdJZ1pxVW8wTlBCeEc4K0x5MTJtNmVTM0Q0SG1MSHNHQlVTMkIrcjZCUlVFR1FBZGdDSGRiL25XWHo0akVPWlg3M3pidjlXalVkV052OUt0V0RCdE9yL1hxQ0REd0FBQVhFV1lFZUdBQUFFQXdCSE1FVUNJRklWcVlxQ0xPN0IweHFIZTF6amdRRnJFWTVuMmJ5LzY4OUhpWlJqb0I4QkFpRUF4VzdicER6N0hrdm94bHR0UW42Uzl5NVcrZ25iVUNTY1dmZmpaNUhMVlNjQWRnQldGQWFhTDlmQzdOUDE0YjFFc2o3SFJuYTV2SmtSWE1EdmxKaFYxb25RM1FBQUFYRVdZRWVTQUFBRUF3QkhNRVVDSUJMMUFlcWpndnVnSktxb3BLemxwRC9DVlBRN1p5Rkc4aWlyd1JuZmNyMUJBaUVBMnRwb0hYUndiYm1IVGxkbEtvc21RWUduWGxteS9henRpbXFvaHZPWW4za0FkZ0NrdVFtUXRCaFlGSWU3RTZMTVozQUtQRFdZQlBrYjM3ampkODBPeUEzY0VBQUFBWEVXWUVkcEFBQUVBd0JITUVVQ0lGb2NkS1U5SFNKazMwY1FqSHZ3OEpHNFNOK2p1VkY4dnJxOTFRM0d6ZG91QWlFQWtHRFcyUG9lcWQ0bkRFWGo1TVJFdWtLM095MDBoRjFZZlBkQWdPSDVVYWt3RGdZRFZSMFBBUUgvQkFRREFnV2dNQjBHQTFVZEpRUVdNQlFHQ0NzR0FRVUZCd01CQmdnckJnRUZCUWNEQWpBekJnTlZIUjhFTERBcU1DaWdKcUFraGlKb2RIUndPaTh2WTNKc0xtVnVkSEoxYzNRdWJtVjBMMnhsZG1Wc01Xc3VZM0pzTUVzR0ExVWRJQVJFTUVJd05nWUtZSVpJQVliNmJBb0JCVEFvTUNZR0NDc0dBUVVGQndJQkZocG9kSFJ3T2k4dmQzZDNMbVZ1ZEhKMWMzUXVibVYwTDNKd1lUQUlCZ1puZ1F3QkFnSXdhQVlJS3dZQkJRVUhBUUVFWERCYU1DTUdDQ3NHQVFVRkJ6QUJoaGRvZEhSd09pOHZiMk56Y0M1bGJuUnlkWE4wTG01bGREQXpCZ2dyQmdFRkJRY3dBb1luYUhSMGNEb3ZMMkZwWVM1bGJuUnlkWE4wTG01bGRDOXNNV3N0WTJoaGFXNHlOVFl1WTJWeU1COEdBMVVkSXdRWU1CYUFGSUtpY0hUZHZGTS96M3ZVOTgxL3AyREdDa3kvTUIwR0ExVWREZ1FXQkJRQXZZaFFrOGhwS1MvSjRJNTV1b0pHcnpQcnFqQUpCZ05WSFJNRUFqQUFNQTBHQ1NxR1NJYjNEUUVCQ3dVQUE0SUJBUUJUMENKdmVhVVkrdEhYWHpBL0c3TXNQd3RKdkcwV2xtRGpEaWt4T28ySS90bHdSN3I5TTEzZlNTUlBFaUZaSFYwVWZhNUEwZHl4cGJySmdkdkI0U0QrK3pHUE11S25hdkVaZnl1ZWlQZWtubzdod2xJTHozWXhSZ2ttNEtEWndZdWJSbjVhUC9lZkNBbE1PZlB3VVdGTmVPOWV5dUd0SXhMbit1cjN2aTFrZktrbVZDR1ppUHpRL3I4ZWxhalFsZzhkNU9uNEJ4V2FsdWh4WDdCLzZPeWRuOGFXUjZSL1diOXJaN1ljUFlXL0tMYnN6ZndFQXVIT3ZJSlNoVWQrSDBWOTdyZWhDQ0dEUlRxS2Z1MndmOElpV0JHdzJYbU1xK0NNNDFIU0YrTnc0REphRHVUL1FIMElFZlZ6eXMrSlZwd0ZWM0FBZUNJT0FFTUN1a3B1UDdhcTwvZHM6WDUwOUNlcnRpZmljYXRlPjwvZHM6WDUwOURhdGE+PC9kczpLZXlJbmZvPjwvZHM6U2lnbmF0dXJlPjxzYW1scDpTdGF0dXM+PHNhbWxwOlN0YXR1c0NvZGUgVmFsdWU9InVybjpvYXNpczpuYW1lczp0YzpTQU1MOjIuMDpzdGF0dXM6U3VjY2VzcyIvPjwvc2FtbHA6U3RhdHVzPjxzYW1sOkFzc2VydGlvbiBJRD0ibkFvUGhXNHpsLTZNX3Y2VDhQeFRNT3FYYVdPIiBJc3N1ZUluc3RhbnQ9IjIwMjAtMTEtMTJUMTA6MTc6MzAuMDc5WiIgVmVyc2lvbj0iMi4wIiB4bWxuczpzYW1sPSJ1cm46b2FzaXM6bmFtZXM6dGM6U0FNTDoyLjA6YXNzZXJ0aW9uIj48c2FtbDpJc3N1ZXI+aHR0cHM6Ly9mZWRhdXRoLnBnLmNvbTwvc2FtbDpJc3N1ZXI+PHNhbWw6U3ViamVjdD48c2FtbDpOYW1lSUQgRm9ybWF0PSJ1cm46b2FzaXM6bmFtZXM6dGM6U0FNTDoxLjE6bmFtZWlkLWZvcm1hdDp1bnNwZWNpZmllZCI+dGlzYW5hcGxhbnVzZXJ1YXQuaW1AcGcuY29tPC9zYW1sOk5hbWVJRD48c2FtbDpTdWJqZWN0Q29uZmlybWF0aW9uIE1ldGhvZD0idXJuOm9hc2lzOm5hbWVzOnRjOlNBTUw6Mi4wOmNtOmJlYXJlciI+PHNhbWw6U3ViamVjdENvbmZpcm1hdGlvbkRhdGEgUmVjaXBpZW50PSJodHRwczovL3NkcC5hbmFwbGFuLmNvbS9mcm9udGRvb3Ivc2FtbC9wZ2ZlZHNhbWwiIE5vdE9uT3JBZnRlcj0iMjAyMC0xMS0xMlQxMDoyMjozMC4wNzlaIiBJblJlc3BvbnNlVG89Il8xYTY0NDU2ZC0xNzViNzYwMmIyZC01MGM2Ii8+PC9zYW1sOlN1YmplY3RDb25maXJtYXRpb24+PC9zYW1sOlN1YmplY3Q+PHNhbWw6Q29uZGl0aW9ucyBOb3RCZWZvcmU9IjIwMjAtMTEtMTJUMTA6MTI6MzAuMDc5WiIgTm90T25PckFmdGVyPSIyMDIwLTExLTEyVDEwOjIyOjMwLjA3OVoiPjxzYW1sOkF1ZGllbmNlUmVzdHJpY3Rpb24+PHNhbWw6QXVkaWVuY2U+aHR0cHM6Ly9zZHAuYW5hcGxhbi5jb208L3NhbWw6QXVkaWVuY2U+PC9zYW1sOkF1ZGllbmNlUmVzdHJpY3Rpb24+PC9zYW1sOkNvbmRpdGlvbnM+PHNhbWw6QXV0aG5TdGF0ZW1lbnQgU2Vzc2lvbkluZGV4PSJuQW9QaFc0emwtNk1fdjZUOFB4VE1PcVhhV08iIEF1dGhuSW5zdGFudD0iMjAyMC0xMS0xMlQxMDoxNzoyOS41MDJaIj48c2FtbDpBdXRobkNvbnRleHQ+PHNhbWw6QXV0aG5Db250ZXh0Q2xhc3NSZWY+dXJuOm9hc2lzOm5hbWVzOnRjOlNBTUw6Mi4wOmFjOmNsYXNzZXM6dW5zcGVjaWZpZWQ8L3NhbWw6QXV0aG5Db250ZXh0Q2xhc3NSZWY+PC9zYW1sOkF1dGhuQ29udGV4dD48L3NhbWw6QXV0aG5TdGF0ZW1lbnQ+PC9zYW1sOkFzc2VydGlvbj48L3NhbWxwOlJlc3BvbnNlPg=="))
		.exec(http("request_15")
			.get(uri3 + "/login?service=https://us1a.app.anaplan.com/launchpad/nonpublic/WorkspaceRedirect.action")
			.headers(headers_15))

	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}