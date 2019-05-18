package khalid.com.groupierecyclerviewsample.numbersExample

import com.xwray.groupie.ExpandableGroup
import com.xwray.groupie.ExpandableItem
import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import khalid.com.groupierecyclerviewsample.R
import kotlinx.android.synthetic.main.expandable_item.*

/**
 * Created by ${KhalidToak} on 3/11/2019.
 */
class ExpandableItem(private val title : String) : Item(), ExpandableItem {
    //declare  an expandable group
    private lateinit var expandableGroup: ExpandableGroup
    override fun bind(viewHolder: ViewHolder, position: Int) {
        viewHolder.apply {
            //bind your views with your viewholder
            item_expandable_header_title.text = title
            item_expandable_header_icon.setImageResource(getIcon())
            //toggle section when header is clicked
            item_expandable_header_root.setOnClickListener {
                expandableGroup.onToggleExpanded()
            }
        }
    }
    //specify layout for expandable item
    override fun getLayout(): Int  = R.layout.expandable_item
    //configure how you want to set the expandable group
    override fun setExpandableGroup(onToggleListener: ExpandableGroup) {
        expandableGroup = onToggleListener
    }
    //toggle icon depending on whether item is expanded or not
    private fun getIcon()= if (expandableGroup.isExpanded) R.drawable.ic_keyboard_arrow_down_black_24dp else
        R.drawable.ic_keyboard_arrow_down_black_24dp

}