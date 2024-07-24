package util.logger

import java.io.File
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


class DesktopLogger: LoggerProvider {
    override fun log(message: String) {
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        val timestamp = LocalDateTime.now().format(formatter)
        File("app.log").appendText("[$timestamp] $message\n")
    }
}

actual fun provideLogger(): LoggerProvider = DesktopLogger()