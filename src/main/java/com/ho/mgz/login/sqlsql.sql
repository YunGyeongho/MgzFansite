create table mgzMember2(
	m_photo varchar2(100 char) not null,
	m_id varchar2(15 char) primary key,
	m_pw varchar2(15 char) not null,
	m_nickname varchar2(10 char) not null,
	m_birthday date not null,
	m_block varchar2(80 char) not null,
	m_addr varchar2(80 char) not null
)

select * from mgzGallery4;
select * from mgzMember2;

select * from MGZMEMBER2 where m_id = #{m_id}

create table mgzGallery4(
	ms_no number(5) primary key,
	ms_writer varchar2(15 char) not null,
	ms_title varchar2(20 char) not null,
	ms_txt varchar2(500 char) not null,
	ms_date date not null,
	ms_color varchar2(9 char) not null,
	constraint sns_writer foreign key(ms_writer) references mgzMember2(m_id) on delete cascade 
);

drop table mgzGallery3 cascade constraint purge;

create sequence mgzGallery3_seq; 

create table mgzGallery4_weather_color(
	mwc_hour number(2) not null,
	mwc_temp number(4, 2) not null,
	mwc_humidity number(4, 2) not null,
	mwc_weather varchar2(10 char)not null,
	mwc_color varchar2(9 char) not null
);

select * from mgzGallery4_weather_color;

select * from (select rownum as rn, ms_no, m_photo, ms_writer, ms_title, ms_txt, ms_date, ms_color from (select rownum, ms_no, ms_writer, m_photo, ms_title, ms_txt, ms_date, ms_color from mgzmember2, mgzGallery4 where m_id = ms_writer order by ms_no desc)) where rn >= #{start} and rn <= #{end}

select * from mgzGallery4;

create table mgzGallery5_reply(
	msr_no number(6) primary key,
	msr_m_photo varchar2(100 char) not null,
	msr_ms_no number(5) not null,
	msr_writer varchar2(15 char) not null,
	msr_txt varchar2(150 char) not null,
	msr_date date not null,
	constraint sns_reply2 foreign key (msr_ms_no) references mgzGallery4(ms_no) on delete cascade
);

create sequence mgzGallery4_reply_seq;
drop table mgzGallery4_reply cascade constraint purge;

create table mgzDataroom5(
	md_no number(5) primary key,
	md_uploader varchar2(15 char) not null,
	md_title varchar2(20 char) not null,
	md_category varchar2(10 char) not null,
	md_file varchar2(100 char) not null,
	md_date date not null
);

create sequence mgzDataroom5_seq;
select * from mgzDataroom5;
