server {
    listen 80 default_server;
    listen [::]:80 default_server;

    # Catch all
    server_name _;

    root <?= getenv('webRootDirPath') ?>;

    index index.php;
    try_files $uri /index.php?$args;

    location ~ \.php$ {
        include snippets/fastcgi-php.conf;
        fastcgi_pass unix:/run/php/php-fpm.sock;
    }
}