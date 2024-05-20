package com.example.animalcatalogue

import CatalogueAdapter
import CatalogueItem
import HorizontalImageAdapter
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager2
    private lateinit var adapter: CatalogueAdapter
    private lateinit var horizontalRecyclerView: RecyclerView
    private lateinit var horizontalAdapter: HorizontalImageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        viewPager = findViewById(R.id.viewPager)
        horizontalRecyclerView = findViewById(R.id.horizontalRecyclerView)

        // Sample data
        val items = listOf(
            CatalogueItem(
                "\t\t\tAnimal Catalogue: Capybara",
                R.drawable.capybara,
                "Ever heard of a creature that looks like a guinea pig got super-sized and decided to take up yoga? That's the capybara for you! Capybaras are the ultimate socialites of the animal kingdom, forming tight-knit groups and casually hanging out in hot springs like they're having a spa day.\n\nIf there's one lesson to learn from these oversized hamsters, it's to live life at your own pace. So, just channel your inner capybara, find a sunny spot, and take a nap like a pro."
            ),
            CatalogueItem(
                "\t\t\tAnimal Catalogue: Chinchilla",
                R.drawable.chinchilla,
                "A fuzzball so soft, it feels like you're petting a cloud, with eyes so big and adorable, they could melt the heart of even the grumpiest of grumps. That's the chinchilla – nature's equivalent of a living, breathing stuffed animal.\n\nThese tiny bundles of joy are like the Energizer Bunnies of the rodent world, bouncing around with boundless enthusiasm like they've had one too many espressos. Seriously, they've got moves that would put even the most hyperactive toddler to shame."
            ),
            CatalogueItem(
                "\t\t\tAnimal Catalogue: Guinea Pig",
                R.drawable.guinea_pig,
                "Imagine a furry little potato with legs, a snout that's basically a built-in snack detector. That's the guinea pig – nature's pocket-sized bundle of joy.\n\nDon't let their pudgy appearance fool you – guinea pigs are fierce explorers. Give them a maze, and they'll navigate it with the determination of a detective solving a case. And don't even get me started on their vocal talents – these little chatterboxes have a repertoire of squeaks, chirps, and wheeks that could rival a choir of angels."
            ),
            CatalogueItem(
                "\t\t\tAnimal Catalogue: Wombat",
                R.drawable.wombat,
                "Adorable creature that's part teddy bear, part tank, and entirely adorable. That's the wombat – the furry bulldozer of the Australian outback.\n\nThese rotund rascals are like the engineers of the animal kingdom, with a talent for digging burrows that would make even the most seasoned miners jealous. Seriously, they're like the underground architects of the bush, crafting cozy homes with all the comforts of a luxury cave."
            )
        )

        // Set up ViewPager
        adapter = CatalogueAdapter(items)
        viewPager.adapter = adapter

        // Set up Horizontal RecyclerView
        horizontalAdapter = HorizontalImageAdapter(items)
        horizontalRecyclerView.adapter = horizontalAdapter
        horizontalRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        findViewById<Button>(R.id.previousButton).setOnClickListener {
            val currentItem = viewPager.currentItem
            if (currentItem > 0) {
                viewPager.currentItem = currentItem - 1
                horizontalRecyclerView.scrollToPosition(currentItem - 1)
            }
        }

        findViewById<Button>(R.id.nextButton).setOnClickListener {
            val currentItem = viewPager.currentItem
            if (currentItem < adapter.itemCount - 1) {
                viewPager.currentItem = currentItem + 1
                horizontalRecyclerView.scrollToPosition(currentItem + 1)
            }
        }
    }
}
