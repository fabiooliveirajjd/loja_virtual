SELECT constraint_name
FROM information_schema.constraint_column_usage
WHERE table_name = 'usuario_acesso' and column_name = 'acesso_id'
and constraint_name<> 'unique_acesso_user';

alter table usuario_acesso  drop constraint "uk_fhwpg5wu1u5p306q8gycxn9ky";