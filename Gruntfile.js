// IDEA FROM: https://gist.github.com/sebz/efddfc8fdcb6b480f567
var yaml = require("yamljs");
var S = require("string");

var CONTENT_PATH_PREFIX = "site/content";

module.exports = function(grunt) {

    grunt.registerTask("lunr-index", function() {

        grunt.log.writeln("Build pages index");

        var indexPages = function() {
            var pagesIndex = [];
            grunt.file.recurse(CONTENT_PATH_PREFIX, function(abspath, rootdir, subdir, filename) {
                grunt.verbose.writeln("Parse file:",abspath);
                var pageIndex = processFile(abspath, filename);
                if (pageIndex != null){
                    pagesIndex.push(pageIndex);
                }
            });

            return pagesIndex;
        };

        var processFile = function(abspath, filename) {
            var pageIndex;

            if (S(filename).startsWith("_index")){
                return null;
            }
            if (S(filename).endsWith(".html") ) {
                pageIndex = processHTMLFile(abspath, filename);
            } else {
                pageIndex = processMDFile(abspath, filename);
            }

            return pageIndex;
        };

        var processHTMLFile = function(abspath, filename) {
        //     var content = grunt.file.read(abspath);
        //     var pageName = S(filename).chompRight(".html").s;
        //     var href = S(abspath)
        //         .chompLeft(CONTENT_PATH_PREFIX).s;
        //     return {
        //         title: pageName,
        //         href: href,
        //         content: S(content).trim().stripTags().stripPunctuation().s
        //     };
        return null;
        };

        var processMDFile = function(abspath, filename) {
            var content = grunt.file.read(abspath);
            var pageIndex;
            // First separate the Front Matter from the content and parse it
            content = content.split("---");
            var frontMatter;
            try {
                if (content[1] != ''){
                    frontMatter = yaml.parse(content[1].trim());
                    grunt.verbose.writeln("frontmatter: ",frontMatter);
                } else
                    return null;
            } catch (e) {
                //console.failed(e.message);
                grunt.log.write(e.message);
                return null;
            }

            var href = S(abspath).chompLeft(CONTENT_PATH_PREFIX).chompRight(".md").s;
            // href for index.md files stops at the folder name
            if (filename === "index.md") {
                href = S(abspath).chompLeft(CONTENT_PATH_PREFIX).chompRight(filename).s;
            }

            // Build Lunr index for this page
            pageIndex = {
                id: href.replace(/\//g,"_").concat("_"),  // We add a final underscore as .RelPermalink does end with /
                title: frontMatter.title,
                tags: frontMatter.tags,
                href: href,
                content: S(content[2]).trim().stripTags().stripPunctuation().s
            };
            grunt.verbose.writeln("pageIndex: ", pageIndex); 
            return pageIndex;
        };

        grunt.file.write("site/static/js/lunr/PagesIndex.json", JSON.stringify(indexPages(), null, 3));
        grunt.log.ok("Index built");
    });
};