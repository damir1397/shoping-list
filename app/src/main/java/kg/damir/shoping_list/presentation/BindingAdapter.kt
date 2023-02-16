package kg.damir.shoping_list.presentation

import androidx.databinding.BindingAdapter
import com.google.android.material.textfield.TextInputLayout
import kg.damir.shoping_list.R

@BindingAdapter("errorInputName")
fun bindingErrorInputName(textInputLayout: TextInputLayout, isError: Boolean) {
    val message = if (isError) {
        textInputLayout.context.getString(R.string.error_input_name)
    } else {
        null
    }
    textInputLayout.error = message
}
@BindingAdapter("errorInputCount")
fun bindingErrorInputCount(textInputLayout: TextInputLayout, isError: Boolean) {
    val message = if (isError) {
        textInputLayout.context.getString(R.string.error_input_count)
    } else {
        null
    }
    textInputLayout.error = message
}
