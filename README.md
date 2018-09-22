# Treebank Visualization
[![Dependencies Status](http://jarkeeper.com/rm-hull/treebank-viz/status.svg)](http://jarkeeper.com/rm-hull/treebank-viz)
[![Docker Pulls](https://img.shields.io/docker/pulls/richardhull/treebank-viz.svg?maxAge=2592000)](https://hub.docker.com/r/richardhull/treebank-viz/)
[![Maintenance](https://img.shields.io/maintenance/yes/2018.svg?maxAge=2592000)]()

SVG graph generation of treebank language parsing.

Start with:

    $ lein ring server

SVG graph of
["Find the two week period in the next six months with the most European conferences?"](https://treebank-viz-xbudysqgpr.now.sh/svg?q=Find+the+two+week+period+in+the+next+six+months+with+the+most+European+conferences%3F)*
yields:

![SVG](https://rawgithub.com/rm-hull/treebank-viz/master/example.svg)

for example, or similar [text representation](https://treebank-viz-xbudysqgpr.now.sh/text?q=Find+the+two+week+period+in+the+next+six+months+with+the+most+European+conferences%3F)
produces a clojure-readable data structure as follows:

```clojure
{:desc "Unknown",
 :id :G__5472,
 :tag TOP,
 :chunk
 ({:desc "Verb Phrase. ",
   :id :G__5473,
   :tag VP,
   :chunk
   ({:desc "Verb, base form", :id :G__5474, :tag VB, :chunk ("Find")}
    {:desc "Noun Phrase. ",
     :id :G__5475,
     :tag NP,
     :chunk
     ({:desc "Noun Phrase. ",
       :id :G__5476,
       :tag NP,
       :chunk
       ({:desc "Noun Phrase. ",
         :id :G__5477,
         :tag NP,
         :chunk
         ({:desc "Determiner", :id :G__5478, :tag DT, :chunk ("the")}
          {:desc "Cardinal number",
           :id :G__5479,
           :tag CD,
           :chunk ("two")}
          {:desc "Noun, singular or mass",
           :id :G__5480,
           :tag NN,
           :chunk ("week")}
          {:desc "Noun, singular or mass",
           :id :G__5481,
           :tag NN,
           :chunk ("period")})}
        {:desc "Prepositional Phrase.",
         :id :G__5482,
         :tag PP,
         :chunk
         ({:desc "Preposition or subordinating conjunction",
           :id :G__5483,
           :tag IN,
           :chunk ("in")}
          {:desc "Noun Phrase. ",
           :id :G__5484,
           :tag NP,
           :chunk
           ({:desc "Determiner", :id :G__5485, :tag DT, :chunk ("the")}
            {:desc "Adjective", :id :G__5486, :tag JJ, :chunk ("next")}
            {:desc "Cardinal number",
             :id :G__5487,
             :tag CD,
             :chunk ("six")}
            {:desc "Noun, plural",
             :id :G__5488,
             :tag NNS,
             :chunk ("months")})})})}
      {:desc "Prepositional Phrase.",
       :id :G__5489,
       :tag PP,
       :chunk
       ({:desc "Preposition or subordinating conjunction",
         :id :G__5490,
         :tag IN,
         :chunk ("with")}
        {:desc "Noun Phrase. ",
         :id :G__5491,
         :tag NP,
         :chunk
         ({:desc "Determiner", :id :G__5492, :tag DT, :chunk ("the")}
          {:desc "Adjective Phrase.",
           :id :G__5493,
           :tag ADJP,
           :chunk
           ({:desc "Adverb, superlative",
             :id :G__5494,
             :tag RBS,
             :chunk ("most")}
            {:desc "Adjective",
             :id :G__5495,
             :tag JJ,
             :chunk ("European")})}
          {:desc "Noun, singular or mass",
           :id :G__5496,
           :tag NN,
           :chunk ("conferences?")})})})})})}
```

There's also a [JSON representation](https://treebank-viz-xbudysqgpr.now.sh/json?q=Find+the+two+week+period+in+the+next+six+months+with+the+most+European+conferences%3F).


<sup>*</sup> - Question attribution: [@garybernhardt](https://twitter.com/garybernhardt/status/376145933827727360)


References
----------
* http://www.ling.upenn.edu/courses/Fall_2003/ling001/penn_treebank_pos.html

License
-------

## The MIT License (MIT)

Copyright (c) 2016 Richard Hull

Permission is hereby granted, free of charge, to any person obtaining a copy of
this software and associated documentation files (the "Software"), to deal in
the Software without restriction, including without limitation the rights to
use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
the Software, and to permit persons to whom the Software is furnished to do so,
subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

