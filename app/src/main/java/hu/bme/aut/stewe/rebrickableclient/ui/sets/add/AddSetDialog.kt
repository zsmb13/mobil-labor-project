package hu.bme.aut.stewe.rebrickableclient.ui.sets.add

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.util.Log
import hu.bme.aut.stewe.rebrickableclient.R
import hu.bme.aut.stewe.rebrickableclient.ui.sets.SetsActivity
import kotlinx.android.synthetic.main.dialog_add_set.*


class AddSetDialog : DialogFragment() {

    lateinit var setsActivity: SetsActivity

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialogView = super.onCreateDialog(savedInstanceState)
        dialogView.setContentView(R.layout.dialog_add_set)

        with(dialogView) {
            addSet.setOnClickListener {
                setsActivity.addSetToSetList(addSetNumber.text.toString())
                dismiss()
            }

            addSetCancel.setOnClickListener {
                dismiss()
            }
        }

        return dialogView
    }

    companion object {
        fun newInstance(): AddSetDialog {
            return AddSetDialog()
        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        try {
            setsActivity = context as SetsActivity
        } catch (e: ClassCastException) {
            Log.e("AddSetDialog", "Dialog should only be attached to a SetsActivity!")
        }
    }
}