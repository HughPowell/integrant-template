# hughpowell.co.uk/integrant-template

A [deps-new](https://github.com/seancorfield/deps-new) template to generate an app that is configured using
[Integrant](https://github.com/weavejester/integrant).

## Usage

This is a template project for use with [deps-new](https://github.com/seancorfield/deps-new).

It will produce a new Integrant application project when run:

    $ clojure -Sdeps '{:deps {io.github.HughPowell/integrant-template {:git/sha "b8dc3cc" :git/tag "1.0.3"}}}' -Tnew create :template hughpowell.co.uk/integrant-template :name myusername/mynewproject

To create a new Integrant application project from a local clone of this repo run:

    $ clojure -Sdeps '{:deps {hughpowell.co.uk/integrant-template {:local/root "."}}}' -Tnew create :template hughpowell.co.uk/integrant-template :name myusername/mycoollib

Assuming you have installed `deps-new` as your `new` "tool" via:

```bash
clojure -Ttools install io.github.seancorfield/deps-new '{:git/tag "v0.4.9"}' :as new
```

Run this template project's tests (by default, this just validates your template's `template.edn`
file -- that it is valid EDN and it satisfies the `deps-new` Spec for template files):

    $ clojure -T:build test

## License

Copyright © 2022 Hugh Powell

Distributed under the Eclipse Public License version 1.0.
