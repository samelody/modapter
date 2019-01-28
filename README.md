# Modapter

![Android](https://img.shields.io/badge/platform-Android-brightgreen.svg)
![Apache](https://img.shields.io/github/license/samelody/modapter.svg)
![API](https://img.shields.io/badge/API-15%2B-brightgreen.svg)
[![Bintray](https://api.bintray.com/packages/belinwu/maven/modapter/images/download.svg)](https://bintray.com/belinwu/maven/modapter/_latestVersion)

Modular adapter for Android RecyclerView.

**DO NOT USE THIS LIBRARY IN PRODUCTION UNTIL V1.0.0 IS RELEASED.**

# Installation

Add the following dependency to your `build.gradle` file:

```groovy
dependencies {
    // required, core
    implementation 'com.samelody.modapter:modapter-core:0.2.0'
    
    // optional, support android paging library
    implementation 'com.samelody.modapter:modapter-paging:0.2.0'
}
```

# Usage

```java
// create a ModularAdapter object instead of creating new Subclass of RecyclerView.Adapter.
ModularAdapter<AdapterItem> adapter = new ModularAdapter<>();
listView.setAdapter(adapter);

// register item metadata to manager
ItemManager<AdapterItem> manager = adapter.getManager();
manager.register(R.layout.item_gallery_image, ImageViewHolder.class)
        .register(R.layout.item_gallery_date, DateViewHolder.class);

// prepare data list
List<Item> list = new ArrayList<>();
list.add(new ImageItem());
list.add(new DateItem());

// submit list
manager.submitList(list);

// notify adapter if no async differs used
adapter.notifyDataSetChanged();
```

## AsyncDiffer

The `ItemManager` not enable async diffing by default.

You can setup `AsyncDiffer` by your choice. The setting API is `ItemManager#setDiffer()`.

The implemented async differs are following:

- `NonAsyncDiffer`: The non implementation. (default used)
- `ListAsyncDiffer`: The `AsyncListDiffer` implementation.
- `PagedAsyncDiffer`: The `AsyncPagedListDiffer` implementation.

### Using Async Differ

```java
// set differ
manager.setDiffer(new ListAsyncDiffer<>());

// submit list
manager.submitList(list);

// not need to call adapter.notify APIs
```

## ItemManager

All APIs are encapsulated in `ItemManager` interface returned by `ModularAdapter#getManager()`.

```java
// register via layoutId and holderClass
ItemManager<E> register(@LayoutRes int layoutId, Class<T> holderClass);

// register via ItemMetadata
ItemManager<E> register(ItemMetadata metadata);

// unregister via layoutId
ItemManager<E> unregister(@LayoutRes int layoutId);

// setup the data list
ItemManager<E> submitList(List<? extends E> list);

// Gets the item with given position
E getItem(int position);

// Gets current displayed list
List<E> getCurrentList();

// Gets item count
int getItemCount();

// setup async differ
ItemManager<E> setDiffer(AsyncDiffer<E> differ);
```

## Reusing ViewHolder and AdapterItem

### One AdapterItem, Multi ViewHolders (a.k.a. Reuse AdapterItem)

We have one ViewHolder called `BannerImageViewHolder` shows `ImageItem` as a banner image, another ViewHolder called `GridImageViewHolder` shows `ImageItem` as a gallery image in a grid.

```java
public class ImageItem implements AdapterItem { /*...*/ }

public class BannerImageViewHolder extends ItemViewHolder<ImageItem> { /*...*/ }

public class GridImageViewHolder extends ItemViewHolder<ImageItem> { /*...*/ }
```

Register the item metadatas.

```java
adapter.getManager()
        .register(R.layout.item_image_banner, BannerImageViewHolder.class)
        .register(R.layout.item_image_grid, GridImageViewHolder.class);
```

By changing the `ImageItem`'s layoutId to reuse itself.

```java
imageItem.setLayoutId(R.layout.item_image_banner);
// or imageItem.setLayoutId(R.layout.item_image_grid);
```

### Multi AdapterItems, One ViewHolder (a.k.a. Reuse ViewHolder/ItemView)

We have a ad item view display as a card called `AdViewHolder`. It display a image and a title. We also have two adapter items called `MusicItem` and `PlaylistItem`.

Define `AdItem` interface as abstraction for `MusicItem` and `PlaylistItem`, used with `AdViewHolder`.

```java
public interface AdItem extends AdapterItem { 
    String getAdImageUrl();

    String getAdTitle();

    void onAdClicked();
 }

public class MusicItem implements AdItem { /*...*/ }

public class PlaylistItem implements AdItem { /*...*/ }

public class AdViewHolder extends ItemViewHolder<AdItem> { /*...*/ }
```

Now, `AdViewHolder` be reused, and the `onAdClicked()`'s behavior determined by the `AdItem`, it implements the **Data-Driven-Development**.

# License

```
Copyright 2019 Samelody.com

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```