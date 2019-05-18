package khalid.com.groupierecyclerviewsample.numbersExample

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import com.xwray.groupie.ExpandableGroup
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Section
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import khalid.com.groupierecyclerviewsample.R

import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    private val secondSection = Section()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val listedNumbs = getColoredNumbs(6)
        val gridNums = getColoredNumbs(12)
        val groupAdapter = GroupAdapter<ViewHolder>().apply {
            spanCount = 3
        }
        recycler_view.apply {
            layoutManager = GridLayoutManager(this@MainActivity, groupAdapter.spanCount).apply {
                spanSizeLookup =  groupAdapter.spanSizeLookup
            }
            adapter = groupAdapter
        }
        ExpandableGroup(ExpandableItem("First Section"), true).apply {
            add(Section(listedNumbs))
            groupAdapter.add(this)
        }
        ExpandableGroup(ExpandableItem("Second secondSection"), false).apply {
            secondSection.addAll(gridNums)
            add(secondSection)
            groupAdapter.add(this)
        }
        fab.setOnClickListener{
            gridNums.shuffle()
            secondSection.update(gridNums)
        }
    }
    private fun getColoredNumbs(count: Int): MutableList<RecyclerItem>{
        val random = Random()
        return MutableList(count){
            val color = Color.argb(255, random.nextInt(256),
                random.nextInt(256), random.nextInt(256))
            RecyclerItem(color, random.nextInt(100))
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
