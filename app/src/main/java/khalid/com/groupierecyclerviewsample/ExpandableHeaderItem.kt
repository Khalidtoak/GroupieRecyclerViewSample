package khalid.com.groupierecyclerviewsample

import com.xwray.groupie.ExpandableGroup
import com.xwray.groupie.ExpandableItem
import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.expandable_layout_item.*

/**
 * Created by ${KhalidToak} on 3/11/2019.
 */
class ExpandableHeaderItem(private val title : String) : Item(), ExpandableItem {
    private lateinit var expandableGroup: ExpandableGroup
    override fun bind(viewHolder: ViewHolder, position: Int) {
        viewHolder.apply {
            item_expandable_header_title.text = title
            item_expandable_header_icon.setImageResource(getIcon())
        }
    }

    override fun getLayout(): Int  = R.layout.expandable_layout_item
    override fun setExpandableGroup(onToggleListener: ExpandableGroup) {
        expandableGroup = onToggleListener
    }
    private fun getIcon()= if (expandableGroup.isExpanded) R.drawable.ic_keyboard_arrow_down_black_24dp else
        R.drawable.ic_keyboard_arrow_down_black_24dp

}