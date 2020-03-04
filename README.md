# eduk8s-hub.io

Site for eduk8s hub.

## Build the site
This site is built with [hugo](https://gethugo.io)

```bash
hugo server
```

## Create a new lab entry
We provide templates for creating new labs. Just use hugo's capability of creating articles from an archetype.

```bash
hugo new labs/example.md
```

You'll find the file in labs/example.md. Go there and tweak the frontmatter as needed.

By default, the lab will be created as draft. If you want to see it rendered, start hugo like this:

```bash
hugo server -D
```

Once you're finished, remove the draft annotation in frontmatter and will be published.