package util.logger

import java.io.File
import java.util.Date

class AndroidLogger: LoggerProvider {
    override fun log(message: String) {
        File("app.log").appendText("[${Date()}] $message\n")
    }
}

actual fun provideLogger(): LoggerProvider = AndroidLogger()