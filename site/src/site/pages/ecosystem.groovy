layout 'layouts/main.groovy', true,
        pageTitle: 'The Grails Framework - Ecosystem',
        mainContent: contents {
            div(id: 'content', class: 'page-1') {
                section(class: 'row') {
                    div(class: 'row-fluid') {
                        div(class: 'col-lg-3') {
                            include template: 'includes/community-navbar.groovy'
                        }
                        div(class: 'col-lg-8 col-lg-pull-0') {
                            include template: 'includes/contribute-button.groovy'
                            h1 {
                                i(class: 'fa fa-leaf') {}
                                yield ' Ecosystem'
                            }
                            p {
                                yield '''
                                        Beside the language and its API, Groovy gave birth to a fruitful ecosystem of projects around it,
                                        on various themes such as web frameworks, desktop application framework, concurrency, testing, and more.
                                        In this section, we'll highlight a few of the most well-known and successful projects,
                                        which leverage Groovy at their core.
                            '''
                            }
                            hr(class: 'divider')

                            ecosys.eachWithIndex { e, index ->
                                def (name, item) = [e.key, e.value]
                                article {
                                    a(name: "${name}") {}
                                    div(class:"content-heading clearfix media") {
                                        div {
                                            if (item.logo) {
                                                img class: "pull-${(index % 2 == 0) ? 'left' : 'right'}", width: 250, src: item.logo, alt: name, hspace: '20px'
                                            } else {
                                                h2(name)
                                            }
                                            p(item.description)
                                        }
                                        a(href: item.url, target:'_blank', "Learn more...")
                                    }
                                }
                                hr(class: 'divider')
                            }
                            article {
                                p """
                                    There are of course many other projects using or built with The Grails Framework.
                                    For instance, you can find some more by having a look at the ${$a(href:'https://github.com/trending?l=groovy', 'trending Groovy projects')} on Github.
                                """
                            }
                        }
                    }
                }
            }
        }