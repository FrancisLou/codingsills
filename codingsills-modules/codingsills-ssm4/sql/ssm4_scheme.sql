drop table if exists sys_user ;
drop table if exists sys_role ;
drop table if exists sys_resource ;
drop table if exists sys_organization ;
drop table if exists r_user_role ;
drop table if exists r_role_resource ;


create table sys_user (
  id         bigint auto_increment, 
  org_id     bigint,                
  user_name  varchar(100),          
  real_name  varchar(64),           
  password   varchar(100),          
  salt       varchar(100),          
  locked     bool default false,    
  email      varchar(100),          
  phone_no   varchar(20),           
  constraint pk_sys_user primary key(id)
) charset=utf8 ENGINE=InnoDB;
create unique index idx_sys_user_username on sys_user(user_name);
create index idx_sys_user_org_id on sys_user(org_id);


create table sys_role (
  id           bigint auto_increment, 
  role         varchar(25),           
  role_cn      varchar(64),           
  description  varchar(250),          
  available    bool default false,    
  constraint pk_sys_role primary key(id)
) charset=utf8 ENGINE=InnoDB;


create table sys_resource (
  id          bigint auto_increment,  
  name        varchar(100),           
  type        varchar(50),            
  url         varchar(200),           
  parent_id   bigint,                 
  permission  varchar(100),           
  available   bool default false,     
  weight      int,                    
  icon        varchar(64),            
  constraint pk_sys_resource primary key(id)
) charset=utf8 ENGINE=InnoDB;
create index idx_sys_resource_parent_id on sys_resource(parent_id);


create table sys_organization (
  id         bigint auto_increment, 
  name       varchar(100),           
  parent_id  bigint,                 
  available  bool default false,     
  constraint pk_sys_organization primary key(id)
) charset=utf8 ENGINE=InnoDB;
create index idx_sys_org_parent_id on sys_organization(parent_id);


create table r_user_role (
	user_id bigint,  
	role_id bigint   
) charset=utf8 ENGINE=InnoDB;


create table r_role_resource (
	role_id     bigint,  
	resource_id bigint   
) charset=utf8 ENGINE=InnoDB;

