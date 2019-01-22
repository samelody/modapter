# Modapter

![Android](https://img.shields.io/badge/platform-Android-brightgreen.svg)
![Apache](https://img.shields.io/github/license/samelody/modapter.svg)
![API](https://img.shields.io/badge/API-15%2B-brightgreen.svg)

Modular adapter for Android RecyclerView.

**DO NOT USE THIS LIBRARY IN PRODUCTION UNTIL V1.0.0 IS RELEASED.**

# Download

Coming soon...

# Getting started

```java
// create a ModularAdapter object instead of creating new Subclass of RecyclerView.Adapter.
ModularAdapter adapter = new ModularAdapter();
recyclerView.setAdapter(adapter);

// register item metadata to manager
ItemManager manager = adapter.getManager();
manager.register(R.layout.item_gallery_image, ImageViewHolder.class)
        .register(R.layout.item_gallery_date, DateViewHolder.class);

// prepare data list
List<Item> list = new ArrayList<>();
list.add(new ImageItem());
list.add(new DateItem());

// Setup list and notify
manager.setList(list);
adapter.notifyDataSetChanged();
```

# Developer Doc

## ItemManager

All APIs are encapsulated in `ItemManager` interface returned by `ModularAdapter#getItemManager()`.

```java
// register via layoutId and holderClass
ItemManager register(@LayoutRes int layoutId, Class<T> holderClass);

// register via ItemMetadata
ItemManager register(ItemMetadata metadata);

// unregister via layoutId
ItemManager unregister(@LayoutRes int layoutId);

// setup the data list
ItemManager setList(List<? extends AdapterItem> list);

// Gets the item with given position
T getItem(int position);
```

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