package khalid.com.groupierecyclerviewsample

import androidx.annotation.ColorInt
import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.recycler_view_ite.*
import kotlinx.android.synthetic.main.recycler_view_ite.view.*

/**
 * Created by ${KhalidToak} on 3/10/2019.
 */
class RecyclerItem(@ColorInt private val color : Int, private val number: Int) : Item(){
    override fun bind(viewHolder: ViewHolder, position: Int) {
        viewHolder.apply {
            item_fancy_cardView.setCardBackgroundColor(color)
            item_fancy_number.text = number.toString()
        }

    }

    override fun getLayout(): Int  = R.layout.recycler_view_ite

    override fun getSpanSize(spanCount: Int, position: Int): Int  = spanCount / 3

}