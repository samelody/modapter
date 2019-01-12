# Modapter

Modular adapter for Android RecyclerView.

This is an **alpha** library until V1.0.0 is released.

**DO NOT USE THIS LIBRARY IN PRODUCTION.**

# Draft usage

```java
Adapter adapter = new Adapter();
recycelrView.setAdapter(adapter);

adapter.getManager()
        .register(R.layout.item_gallery_image, ImageViewHolder.class)
        .register(R.layout.item_gallery_date, DateViewHolder.class);

adapter.getManager().unregister(3);

List<Item> list = new ArrayList<>();
list.add(new ImageItem());
list.add(new DateItem());
list.add(new ImageItem());
list.add(new ImageItem());
adapter.getManager().setList(list);
adapter.notifyDataSetChanged();
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