INSERT INTO w_user(
 user_id
,password
,user_name
,birthday
,age
,gender
)VALUES
('system@co.jp','password','システム管理者','2000-01-01',21,1)
,('user@co.jp','password','トム','2000-01-01',21,1);

INSERT INTO w_entity(
 training
,body_parts
)VALUES
('ベンチプレス','胸'),
('スクワット','足'),
('チンニング','背中');


INSERT INTO t_method(
 training
,training_method
)VALUES
('ベンチプレス','バーベル'),
('スクワット','バーベル'),
('チンニング','バー');


INSERT INTO memory(
 training
,weight
,memory
)VALUES
('ベンチプレス','50kg','10回'),
('スクワット','50kg','10回'),
('チンニング','自重','13回');
