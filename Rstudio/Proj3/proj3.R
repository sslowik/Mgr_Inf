getwd()
setwd("d:/Mgr_Inf/Rstudio/Proj3")

lifetime <- read.csv("lifetime_pl.csv", dec = ",", stringsAsFactors=FALSE)

average_lifetime <- as.vector(lifetime$Srednia)
average_lifetime

life_ts <- ts(average_lifetime, start=c(1950))

life_ts

plot.ts(life_ts)

log_life_ts <- log(life_ts)

plot.ts(log_life_ts)

# smoothing to find trend 

install.packages("TTR")
library("TTR")

life_ts_SMA3 <- SMA(life_ts, n=3)
plot.ts(life_ts_SMA3)

life_ts_SMA7 <- SMA(life_ts, n=7)
plot.ts(life_ts_SMA7)

# Forecasts using Exponential Smoothing
life_ts_forecasts <- HoltWinters(life_ts, beta=FALSE, gamma=FALSE)
life_ts_forecasts
life_ts_forecasts$SSE

life_ts_forecasts$fitted

plot(life_ts_forecasts)

install.packages("forecast")
library("forecast")

lifetime_forecast_10 <- forecast.HoltWinters(life_ts_forecasts, h=10)
lifetime_forecast_10

lifetime_forecast_50 <- forecast.HoltWinters(life_ts_forecasts, h=50)
lifetime_forecast_50

plot(lifetime_forecast_50)

plot.forecast(lifetime_forecast_50)

Box.test(lifetime_forecast_50$residuals, lag=20, type="Ljung-Box")

plot.ts(lifetime_forecast_50$residuals)

# Holt’s Exponential Smoothing

life_ts_forecasts2 <- HoltWinters(life_ts, gamma=FALSE)
life_ts_forecasts2
life_ts_forecasts2$SSE
life_ts_forecasts$SSE

plot(life_ts_forecasts2)
plot(life_ts_forecasts)

life_ts_forecasts2_50 <- forecast.HoltWinters(life_ts_forecasts2, h=50)
plot.forecast(life_ts_forecasts2_50)

life_ts_forecasts2_50$fitted
class(life_ts_forecasts2_50)
