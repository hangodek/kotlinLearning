package com.example.thirtydaysroutines.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Routine(
    @StringRes val day: Int,
    @StringRes val dayHeader: Int,
    @DrawableRes val dayImage: Int,
    @StringRes val dayDescription: Int,
)