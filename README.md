# Property App

This repository contains a sample app that implements MVVM architecture using RxJava ,Android Navigation, Retrofit, Glide.

## The app has following packages:

model: It contains all the data classes and api calls.
view: View classes along with list adapter class.
viewModel:Contains viewModel class.

## Design decisions and considerations

* The app is written in Kotlin. I have used Retrofit and RxJava for API call and threading, MVVM architecture, LiveData to notify the view, Glide to display images in the recyclerView.

* With SwipeRefreshLayout, the user can refresh the contents of the view via a vertical swipe gesture.

* A Network Security Configuration xml file has been added to the app to specify the settings for the app.(Needed for API 28)

## Screenshots
![Alt text](/listFragment.jpg?raw=true "ListFragment"){:height="50%" width="50%"}

![Alt text](/detailFragment.jpg?raw=true "DetailFragment"){:height="50%" width="50%"}

