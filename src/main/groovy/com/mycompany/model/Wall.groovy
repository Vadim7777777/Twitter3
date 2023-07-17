package com.mycompany.model;

import lombok.*

import java.util.stream.Collectors

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString
class Wall {

    private List<Post> posts = new ArrayList<Post>();

    void sortByDate() {
        posts = posts.stream()
                .sorted((x, y) -> x.getPostDate() - y.getPostDate())
                .collect(Collectors.toList());
    }

    def setPosts(List<Post> list) {
        posts = list;
    }

    def getPosts() {
        return posts;
    }

}
