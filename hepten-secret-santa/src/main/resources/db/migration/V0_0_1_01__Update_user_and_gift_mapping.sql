alter table public.user
    add gender varchar(16);

create table if not exists public.gift_theme_user_mapping (
    user_id int not null,
    room_id int not null,
    gift_theme_id int not null,
    gift_attribute varchar(256) not null,

    constraint gift_theme_user_mapping_pk primary key (room_id, user_id, gift_theme_id),
    constraint gift_theme_user_mapping_room_fk foreign key (room_id) references public.room(id),
    constraint gift_theme_user_mapping_user_fk foreign key (user_id) references public.user(id),
    constraint gift_theme_user_mapping_gift_theme_fk foreign key (gift_theme_id) references public.gift_theme(id)
);