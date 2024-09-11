### STAGE 1: Build ###
#FROM node AS build
#WORKDIR /usr/src/app
#COPY package.json package-lock.json ./
#RUN npm install
#COPY . .
#RUN npm run build

### STAGE 2: Run ###
#FROM nginx
#COPY default.conf /etc/nginx/nginx.conf


FROM nginx:1.17.1-alpine
COPY nginx.conf /etc/nginx/nginx.conf
RUN chmod -R 777 /usr/share/nginx/html/*
COPY --from=build /usr/src/app/dist/frontend /usr/share/nginx/html
EXPOSE 4200
