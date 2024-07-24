package ui.screen.home

import domain.model.AppModel
import moe.tlaster.precompose.viewmodel.ViewModel
import myzar.composeapp.generated.resources.Res
import myzar.composeapp.generated.resources.ic_car
import myzar.composeapp.generated.resources.ic_car_crash
import myzar.composeapp.generated.resources.ic_home
import myzar.composeapp.generated.resources.ic_hse
import myzar.composeapp.generated.resources.ic_messages
import myzar.composeapp.generated.resources.ic_password_hide
import myzar.composeapp.generated.resources.ic_setting
import myzar.composeapp.generated.resources.ic_student
import myzar.composeapp.generated.resources.ic_train_journey
import util.dispatcher.DispatcherProvider

class HomeViewModel(
    private val dispatcherProvider: DispatcherProvider
) : ViewModel() {


    fun getFirstApps() = listOf(
        AppModel(
            title = "درخواست خودرو1",
            description = "درصورت نیاز به آژانس میتوانید از این ویژگی استفاده کنید.",
            icon = Res.drawable.ic_setting,
            onClick = {}
        ),
        AppModel(
            title = "2درخواست خودرو",
            description = "درصورت نیاز به آژانس میتوانید از این ویژگی استفاده کنید. 1 درصورت نیاز به آژانس میتوانید از این ویژگی استفاده کنید. 2 درصورت نیاز به آژانس میتوانید از این ویژگی استفاده کنید.",
            icon = Res.drawable.ic_password_hide,
            onClick = {}
        ),
        AppModel(
            title = "3درخواست خودرو",
            description = "درصورت نیاز به آژانس میتوانید از این ویژگی استفاده کنید.",
            icon = Res.drawable.ic_home,
            onClick = {}
        ),
        AppModel(
            title = "درخواست خودرو4",
            description = "درصورت نیاز به آژانس میتوانید از این ویژگی استفاده کنید.",
            icon = Res.drawable.ic_setting,
            onClick = {}
        ),
        AppModel(
            title = "درخواست خودرو5",
            description = "درصورت نیاز به آژانس میتوانید از این ویژگی استفاده کنید.",
            icon = Res.drawable.ic_setting,
            onClick = {}
        )
    )

    fun getTowApps() = listOf(
        AppModel(
            title = "بیمه تکمیلی",
            description = "",
            icon = Res.drawable.ic_car_crash,
            onClick = {}
        ),
        AppModel(
            title = "HSE",
            description = "",
            icon = Res.drawable.ic_hse,
            onClick = {}
        ),
        AppModel(
            title = "نظرسنجی",
            description = "درصورت نیاز به آژانس میتوانید از این ویژگی استفاده کنید.",
            icon = Res.drawable.ic_messages,
            onClick = {}
        ),
        AppModel(
            title = "پارکینگ",
            description = "درصورت نیاز به آژانس میتوانید از این ویژگی استفاده کنید.",
            icon = Res.drawable.ic_car,
            onClick = {}
        ),

        )

    fun getThreeApps() = listOf(
        AppModel(
            title = "مرکزآموزشی و دریافت مدارک",
            description = "",
            icon = Res.drawable.ic_student,
            onClick = {}
        ),
        AppModel(
            title = "سرویس و نقشه",
            description = "",
            icon = Res.drawable.ic_train_journey,
            onClick = {}
        ),

        )


}