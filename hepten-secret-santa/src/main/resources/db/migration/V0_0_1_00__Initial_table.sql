create table if not exists public.user (
    id serial primary key not null,
    email text,
    username varchar(256) NOT NULL,
    created_at timestamp default current_timestamp
);

create table if not exists public.nickname_theme (
    id serial primary key not null,
    category varchar(256) not null,
    nicknames text not null
);

create table if not exists public.room (
    id serial primary key,
    room_name varchar(256) not null,
    pass_code varchar(256) not null,
    user_id int not null,
    budget varchar(256) not null,
    nickname_theme_id int not null,
    status varchar(256) not null,

    constraint user_fk foreign key (user_id) references public.user(id),
    constraint nickname_theme_fk foreign key (nickname_theme_id) references public.nickname_theme(id)
);

create table if not exists public.nickname_user_mapping (
  user_id int not null,
  room_id int not null,
  nickname varchar(256) not null,

  constraint nickname_user_mapping_pk primary key (room_id, user_id),
  constraint room_fk foreign key (room_id) references public.room(id),
  constraint user_fk foreign key (user_id) references public.user(id)
);

create table if not exists public.gift_theme (
    id serial primary key,
    category varchar(256) not null,
    attributes text not null
);

create table if not exists public.gift_theme_room_mapping (
    gift_theme_id int not null,
    room_id int not null,

    constraint gift_theme_room_mapping_pk primary key (gift_theme_id, room_id),
    constraint room_fk foreign key (room_id) references public.room(id),
    constraint gift_theme foreign key (gift_theme_id) references public.gift_theme(id)
);

create table if not exists public.room_user_mapping (
    room_id int not null,
    user_id int not null,
    give_to int,

    constraint room_user_mapping_pk primary key (room_id, user_id),
    constraint room_fk foreign key (room_id) references public.room(id),
    constraint user_fk foreign key (user_id) references public.user(id)
);

