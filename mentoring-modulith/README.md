# Mentoring application

## Start database

```shell
docker run -d -e POSTGRES_DB=mentoring -e POSTGRES_USER=mentoring -e POSTGRES_PASSWORD=mentoring -p 5432:5432 --name mentoring-postgres postgres
```