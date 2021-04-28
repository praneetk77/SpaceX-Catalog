package com.example.spacex.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.spacex.R
import com.google.android.material.bottomnavigation.BottomNavigationView



class MainActivity : AppCompatActivity() {


    private val navListener = BottomNavigationView.OnNavigationItemSelectedListener{ item ->
        when(item.itemId){
            R.id.home ->{
                println("Home pressed")
                replaceFragment(HomeFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.face ->{
                println("Face pressed")
                replaceFragment(CompanyFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.fire ->{
                println("Fire pressed")
                replaceFragment(LaunchesFragment())
                return@OnNavigationItemSelectedListener true
            }
            else -> return@OnNavigationItemSelectedListener false
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNav : BottomNavigationView = findViewById(R.id.bottom_navigation_bar)
        bottomNav.setOnNavigationItemSelectedListener(navListener)

        replaceFragment(HomeFragment())

    }

    private fun replaceFragment(fragment : Fragment){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container, fragment)
        fragmentTransaction.commit()
    }

//    https://api.spacex.land/graphql/
//
//
//    gradlew downloadApolloSchema --endpoint="https://apollo-fullstack-tutorial.herokuapp.com/" --schema="src/main/graphql/com/example/spaceX/"
//    mkdir -p app/src/main/graphql/com/example/rocketreserver/
//./gradlew :app:downloadApolloSchema --endpoint=https://apollo-fullstack-tutorial.herokuapp.com/ --schema=app/src/main/graphql/com/example/rocketreserver/schema.json
}