package com.junqueira.a31daysofsucess.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class DailyQuote(
    @StringRes val dayNumberRes: Int,
    @StringRes val titleRes: Int,
    @StringRes val descriptionRes: Int,
    @DrawableRes val imageRes: Int,
)
