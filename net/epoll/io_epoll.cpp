/** 
  epoll测试用例 
  当文件命名是io_epoll.c时，编译选项gcc io_epoll.c有错误，提示unknow type name epoll_event 
  当把文件命名io_epoll.cpp时，编译选项gcc io_epoll.cpp或者g++ io_epoll.c就可以 
*/
  
#include stdio.h  
#include stdlib.h  
#include unistd.h  
#include systypes.h  
#include syssocket.h  
#include sysepoll.h  
#include netinetin.h  
#include arpainet.h  
#include fcntl.h  
#include string.h  
  
#define err_sys(msg)   
    do { perror(msg); exit(-1); } while(0)  
#define err_exit(msg)   
    do { fprintf(stderr, msg); exit(-1); } while(0)  
#define err_info(msg)   
    do { fprintf(stderr, msg); } while(0)  
#define MAXEVENTS 5  
  
void addfd(int epollfd, int fd)  
{  
    epoll_event event;  
    event.data.fd = fd;  
    event.events = EPOLLIN;  
    epoll_ctl(epollfd, EPOLL_CTL_ADD, fd, &event);  
}  
  
int main(int argc, char argv[])  
{  
    if(argc != 2)  
        err_exit(Usage .a.out portn);  
    int port = atoi(argv[1]);  
    int listenfd, connfd;  
    struct sockaddr_in servaddr;  
  
    bzero(&servaddr, sizeof(servaddr));  
    servaddr.sin_family = AF_INET;  
    servaddr.sin_port = htons(port);  
    servaddr.sin_addr.s_addr = htonl(INADDR_ANY);  
    if((listenfd = socket(AF_INET, SOCK_STREAM, 0))  0)  
        err_sys(socket);  
    if(bind(listenfd, (struct sockaddr )&servaddr, sizeof(servaddr))  0)  
        err_sys(bind);  
    if(listen(listenfd, 5)  0)  
        err_sys(listen);  
      
    epoll_event events[MAXEVENTS];  
    int epollfd;  
      
    if((epollfd = epoll_create(5))  0)  
        err_sys(epoll_create);  
    if((connfd = accept(listenfd, NULL, NULL))  0)  
        err_sys(accept);  
      
    addfd(epollfd, connfd);  
    addfd(epollfd, STDIN_FILENO);  
  
    int runing = 1;  
    while(runing)  
    {  
        int i, cnt = epoll_wait(epollfd, events, MAXEVENTS, -1);  
        char buf[1024];  
  
        for(i = 0; i  cnt; i++)  
        {  
            int sockfd = events[i].data.fd;  
            if(sockfd == STDIN_FILENO)  
            {  
                scanf(%s, buf);  
                if(send(connfd, buf, strlen(buf), 0)  0)  
                {  
                    err_info(send errorn);  
                }  
            }  
            else if(sockfd == connfd)  
            {  
                int ret;  
  
                bzero(buf, sizeof(buf));  
                if((ret = recv(sockfd, buf, sizeof(buf) - 1, 0)) = 0)  
                {  
                    if(ret  0)  
                        err_info(recv errorn);  
                    else  
                    {  
                        printf(The client host is termenal. I will go out! Bye!n);  
                        runing = 0;  
                    }  
                }  
                else if(!strcmp(buf, exit))  
                {  
                    printf(I had got the 'exit', I will go out! Byen);  
                    runing = 0;  
                }  
                else  
                {  
                    printf(recv %sn, buf);  
                }  
            }  
        }  
    }  
  
    close(connfd);  
    close(listenfd);  
  
    return 0;  
} 