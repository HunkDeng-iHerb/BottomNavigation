# BottomNavigation
simulate iOS bottom navigation behavior

The difference behavior on Android and iOS is list[here](https://material.io/design/components/bottom-navigation.html#behavior). 

This example project use childFragmentManager to maintain the backstack for each stack/tab fragment. Eventbus build the communication channel between child fragment to stack root fragment, to tell stack root fragment pop/push fragment into backstack. 
