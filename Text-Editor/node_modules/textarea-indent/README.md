
Add a little indentations in textarea
----

Demo http://repo.tiye.me/textarea-indent/

Make leading spaces of a newline based on current line, when pressing `Return`.

### Usage

```
npm i --save textarea-indent
```

```
indent = require 'textarea-indent'

textarea = document.querySelector '#demo'
textarea.addEventListener 'keydown', indent.newlineHandler
```

### Develop

* Development

```text
npm i
gulp html
webpack-dev-server --hot
```

* Production

```text
gulp buld
gulp rsync
```

### License

MIT
