package com.mycompany.model;

import lombok.*

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString
class Wall {

    private List<Post> postList;

}
