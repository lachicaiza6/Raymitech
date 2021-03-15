INSERT INTO Category (id_category,description,slug,title)  VALUES (1, 'Programación','Materias referentes a la programación en diferentes lenguajes','dsdf'); 
INSERT INTO Institute (id_institute,cellphone,domain,email,img,name)  VALUES (1, 'Programación','0959743877','raymmitech.com','img.jpg','raymitech'); 
INSERT INTO User (id_user,email,name,user_name,fk_institute)  VALUES (1, 'luiscont1502@gmail.com','luis','Luiscont',1); 
INSERT INTO Post (id_post,description,name,title,fk_category,fk_user)  VALUES (1,'Programación','lenguajes','la programacion',1,1); 
INSERT INTO Comments (id_comments,user_name,fk_id_post)  VALUES (1,'Luiscont',1); 
INSERT INTO Category_Component (id_cat_component,description,position,title,fk_id_post)  VALUES (1,'Programación','1','dsdf',1); 
INSERT INTO Component_Item (id_component_item,content,img,title,fk_id_cat_component)  VALUES (1,'Programación','img.jpg','dsdf',1); 

