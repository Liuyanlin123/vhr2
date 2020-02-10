create procedure addDep(IN depName varchar(32),
  IN parentId1 int,
  IN enabled1 tinyint(1),
  OUT result int,
  OUT result2 int)
  begin
  declare did int;
  declare pDepPath varchar(64);
  insert into department set name=depName,parentId=parentId1,enabled=enabled1;
  select row_count() into result;
  select last_insert_id() into did;
  set result2=did;
  select depPath into pDepPath from department where id=parentId1;
  update department set depPath=concat(pDepPath,'.',did) where id=did;
  update department set isParent=true where id=parentId1;
end;

