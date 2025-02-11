version: '3.8'

services:
frontend:
build:
context: .
dockerfile: Dockerfile
ports:
        - "8443:8443"
volumes:
        - ./dist:/usr/share/nginx/html
      - ./nginx.conf:/etc/nginx/nginx.conf
      - ./cert.pem:/etc/nginx/certs/cert.pem
      - ./key.pem:/etc/nginx/certs/key.pem
networks:
        - app-network

backend:
image: your-backend-image  # Замени на образ твоего бэкенда
ports:
        - "8443:8443"
networks:
        - app-network

networks:
app-network:
driver: bridge