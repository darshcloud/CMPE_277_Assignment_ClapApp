# CMPE 277 Assignment_ClapApp
Clap App Android Application

Learning Objective: using Proximity (TYPE_PROXIMITY) sensor, develop mobile clap app. The goal is to simulate clapping using mobile phone and hand.

Clap App Launched Successfully

![1](https://user-images.githubusercontent.com/111547793/229615334-7f629357-e5b4-4b1c-90f6-ad116462727e.png)

In the onSensorChanged() method, I will check the distance measured by the mProximity sensor with event.values[0]. If the distance is less than or equal to 5, I will display a Toast message saying Clapping Started and play a sound using the MediaPlayer.start() method.

The clap_sound media file is available in the raw directory.

![2](https://user-images.githubusercontent.com/111547793/229615347-292062a7-00ac-40cc-b6dd-985b2b4e2f72.png)

If the distance greater than 5, I will display a Toast message saying Clapping Stopped as shown in the below screenshot and mediaPlayer will not play any sound.

![3](https://user-images.githubusercontent.com/111547793/229615370-18ef8d71-30f2-4186-8646-6cf23f2d3bd2.png)



