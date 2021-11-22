SELECT
    TABLE_NAME AS '表名',
    COLUMN_NAME AS '字段名',
    COLUMN_TYPE AS '数据类型',
    IS_NULLABLE AS '允许为空',
    EXTRA AS 'PK',
    COLUMN_COMMENT AS '字段说明'
FROM
    information_schema.`COLUMNS`
WHERE
        TABLE_SCHEMA = 'fly_school'
