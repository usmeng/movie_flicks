# Project 1 - *Flicks*

**Flicks** shows the latest movies currently playing in theaters. The app utilizes the Movie Database API to display images and basic information about these movies to the user.

Time spent: **4** hours spent in total

## User Stories

The following **required** functionality is completed:

* [ ] User can **scroll through current movies** from the Movie Database API
* [ ] Layout is optimized with the [ViewHolder](http://guides.codepath.com/android/Using-an-ArrayAdapter-with-ListView#improving-performance-with-the-viewholder-pattern) pattern.
* [ ] For each movie displayed, user can see the following details:
  * [ ] Title, Poster Image, Overview (Portrait mode)
  * [ ] Title, Backdrop Image, Overview (Landscape mode)

The following **optional** features are implemented:

* [ ] Display a nice default [Glide](https://github.com/Masterminds/glide)for each image during loading.

The following **bonus** features are implemented:

* [ ] Allow user to view details of the movie including ratings and popularity within a separate activity or dialog fragment.
* [ ] When viewing a popular movie (i.e. a movie voted for more than 5 stars) the video should show the full backdrop image as the layout.  Uses [Heterogenous RecyclerView](http://guides.codepath.com/android/Heterogenous-Layouts-inside-RecyclerView) to show different layouts.
* [ ] Allow video trailers to be played in full-screen using the YouTubePlayerView.
    * [ ] Overlay a play icon for videos that can be played.
    * [ ] More popular movies should start a separate activity that plays the video immediately.
    * [ ] Less popular videos rely on the detail page should show ratings and a YouTube preview.
* [ ] Apply the popular [RxJava](https://github.com/ReactiveX/RxJava) and [Retrofit] (https://github.com/square/retrofit) to fetch data from web.
* [ ] Apply rounded corners for the poster or background images using [Glide transformations](https://guides.codepath.com/android/Displaying-Images-with-the-Picasso-Library#other-transformations)
* [ ] Replaced android-async-http network client with the popular [OkHttp](http://guides.codepath.com/android/Using-OkHttp) networking libraries.

The following **additional** features are implemented:

* [ ] Use MVP architecture to separate presentation layer and data layer
* [ ] Use ReycleView instead of listview
* [ ] Use Fragment instead of new Activity for editing items
* [ ] Use Constrainlayout instead of Linerlayout and relativelayout

## Video Walkthrough

Here's a walkthrough of implemented user stories:

<img src='https://github.com/usmeng/movie_flicks/blob/master/screenshot/flicks.gif' title='Video Walkthrough' width='' alt='Video Walkthrough' />

GIF created with [LiceCap](http://www.cockos.com/licecap/).

## Notes

Describe any challenges encountered while building the app.

## Open-source libraries used
- [RxJava](https://github.com/ReactiveX/RxJava) - a library for composing asynchronous and event-based programs using observable sequences for the Java VM.
- [Retrofit](https://github.com/square/retrofit) - Type-safe HTTP client for Android and Java by Square, Inc.
- [okhttp](https://github.com/square/okhttp) - An HTTP+HTTP/2 client for Android and Java applications.
- [gson](https://github.com/google/gson) - A Java serialization/deserialization library to convert Java Objects into JSON and back
- [Glide](https://github.com/Masterminds/glide) - Image loading and caching library for Android

## License

    Copyright [2017] [Meng Zhou]

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
