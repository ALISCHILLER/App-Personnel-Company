package util.logger

interface LoggerProvider {
    fun log(message: String)
}

expect fun provideLogger(): LoggerProvider