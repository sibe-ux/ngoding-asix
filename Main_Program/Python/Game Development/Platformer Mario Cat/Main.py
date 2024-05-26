import pygame
from pygame.locals import *

pygame.init()

screen_width = 1280  # lebar
screen_height = 720  # tinggi

screen = pygame.display.set_mode(
    (screen_width, screen_height))  # set rasio game (16:9)
pygame.display.set_caption('Testing Game')  # nama game

# define game variable
tile_size = 64  # menurun
tile_size2 = 36  # mendatar

clock = pygame.time.Clock()
fps = 320  # MENGATUR PERGERAKAN PLAYER, SEMAKIN BANYAK SEMAKIN CEPAT

# load image
bg_img = pygame.image.load(
    f'G:\.shortcut-targets-by-id\\1GLhesaekxPRKr-lkNYX-mtfouqJhqhXN\SIBEUX\Algorithm_Programming\PEMROGRAMAN\Main_Program\Python\Game Development\Platformer Mario Cat\RESOURCE\jungle.jpg')


# def draw_grid():
#     for line in range(0, 20):
#         pygame.draw.line(screen, (255, 255, 255), (0, line *
#                          tile_size2), (screen_width, line*tile_size2))
#         pygame.draw.line(screen, (255, 255, 255), (line *
#                          tile_size, 0), (line*tile_size, screen_height))

class player():
    def __init__(self, x, y):
        self.image_right = []
        self.image_left = []
        self.stand_right = []
        self.stand_left = []
        self.index = 0
        self.counter = 0
        img_stand_right = pygame.image.load(
            f'G:\.shortcut-targets-by-id\\1GLhesaekxPRKr-lkNYX-mtfouqJhqhXN\SIBEUX\Algorithm_Programming\PEMROGRAMAN\Main_Program\Python\Game Development\Platformer Mario Cat\RESOURCE\stand1.png')
        img_stand_right = pygame.transform.scale(img_stand_right, (40, 68))
        img_stand_left = pygame.transform.flip(img_stand_right, True, False)
        self.stand_right.append(img_stand_right)
        self.stand_left.append(img_stand_left)
        for num in range(2, 4):
            img_right = pygame.image.load(
                f'G:\.shortcut-targets-by-id\\1GLhesaekxPRKr-lkNYX-mtfouqJhqhXN\SIBEUX\Algorithm_Programming\PEMROGRAMAN\Main_Program\Python\Game Development\Platformer Mario Cat\RESOURCE\stand{num}.png')
            img_right = pygame.transform.scale(img_right, (50, 65))
            img_left = pygame.transform.flip(img_right, True, False)
            self.image_right.append(img_right)
            self.image_left.append(img_left)
        self.image = self.stand_right[0]
        self.rect = self.image.get_rect()
        self.rect.x = x
        self.rect.y = y
        self.width = self.image.get_width()
        self.height = self.image.get_height()
        self.vel_y = 0
        self.jumped = False
        self.direction = 0

    def update(self):
        dx = 0
        dy = 0
        # run speed (semakin kecil semakin cepat) ini animasi cok bukan real speed
        walk_cooldown = 15
        # get keypresses
        key = pygame.key.get_pressed()
        if key[pygame.K_SPACE] and self.jumped == False:
            self.vel_y = -1.5  # UNTUK MENENTUKAN SEBERAPA TINGGI KARAKTER MELOMPAT
            self.jumped = True
        if key[pygame.K_SPACE] == False:
            self.jumped = False
        if key[pygame.K_LEFT]:
            dx -= 1  # REAL KECEPATAN LARI
            self.counter += 1
            self.direction = -1
        if key[pygame.K_RIGHT]:
            dx += 1  # REAL KECEPATAN LARI
            self.counter += 1
            self.direction = 1
        if key[pygame.K_LEFT] == False and key[pygame.K_RIGHT] == False:
            self.counter = 0
            self.index = 0
            if self.direction == 1:
                # self.image = self.image_right[self.index]
                self.image = self.stand_right[0]
            if self.direction == -1:
                # self.image = self.image_left[self.index]
                self.image = self.stand_left[0]

        # handle animation
        if self.counter > walk_cooldown:
            self.counter = 0
            self.index += 1
            if self.index >= len(self.image_right):
                self.index = 0
            if self.direction == 1:
                self.image = self.image_right[self.index]
            if self.direction == -1:
                self.image = self.image_left[self.index]

        # add gravity
        self.vel_y += 0.03  # UNTUK MENENTUKAN SEBERAPA KUAT GRAVITASINYA
        if self.vel_y > 10:
            self.vel_y = 10
        dy += self.vel_y

        # check for collision
        for tile in world.tile_list:
            # CEK HAMBATAN JIKA DI X DIRECTION (KANAN & KIRI)
            if tile[1].colliderect(self.rect.x+dx, self.rect.y, self.width, self.height):
                dx = 0
                # CEK HAMBATAN DI Y DIRECTION (ATAS & BAWAH)
            if tile[1].colliderect(self.rect.x, self.rect.y + dy, self.width, self.height):
                # cek jika ada di atas tanah (lompat)
                if self.vel_y < 0:
                    dy = tile[1].bottom - self.rect.top
                    self.vel_y = 0
                # cek jika ada di bawah tanah (jatuh)
                elif self.vel_y >= 0:
                    dy = tile[1].top - self.rect.bottom
                    self.vel_y = 0
        # update player coordinates
        self.rect.x += dx
        self.rect.y += dy

        if self.rect.bottom > screen_height:
            self.rect.bottom = screen_height
            dy = 0

        # draw player onto screen
        screen.blit(self.image, self.rect)
        # pygame.draw.rect(screen, (255, 255, 255), self.rect, 2)


class World():
    def __init__(self, data):
        self.tile_list = []

        # upload image
        wood_img = pygame.image.load(
            'G:\.shortcut-targets-by-id\\1GLhesaekxPRKr-lkNYX-mtfouqJhqhXN\SIBEUX\Algorithm_Programming\PEMROGRAMAN\Main_Program\Python\Game Development\Platformer Mario Cat\RESOURCE\wood.jpg')
        stn_img = pygame.image.load(
            'G:\.shortcut-targets-by-id\\1GLhesaekxPRKr-lkNYX-mtfouqJhqhXN\SIBEUX\Algorithm_Programming\PEMROGRAMAN\Main_Program\Python\Game Development\Platformer Mario Cat\RESOURCE\stone.jpg')

        row_count = 0
        for row in data:
            col_count = 0
            for tile in row:
                if tile == 1:
                    img = pygame.transform.scale(
                        wood_img, (tile_size, tile_size2))
                    img_rect = img.get_rect()
                    img_rect.x = col_count * tile_size
                    img_rect.y = row_count * tile_size2
                    tile = (img, img_rect)
                    self.tile_list.append(tile)
                if tile == 2:
                    img = pygame.transform.scale(
                        stn_img, (tile_size, tile_size2))
                    img_rect = img.get_rect()
                    img_rect.x = col_count * tile_size
                    img_rect.y = row_count * tile_size2
                    tile = (img, img_rect)
                    self.tile_list.append(tile)
                col_count += 1
            row_count += 1

    def draw(self):
        for tile in self.tile_list:
            screen.blit(tile[0], tile[1])
            # pygame.draw.rect(screen, (255, 255, 255), tile[1], 2)


world_data = [
    [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1],
    [1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1],
    [1, 0, 0, 0, 0, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8, 1],
    [1, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 7, 0, 0, 0, 0, 0, 2, 2, 1],
    [1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 0, 7, 0, 5, 0, 0, 0, 1],
    [1, 0, 0, 0, 0, 0, 0, 0, 5, 0, 0, 0, 2, 2, 0, 0, 0, 0, 0, 1],
    [1, 7, 0, 0, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1],
    [1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1],
    [1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7, 0, 0, 7, 0, 0, 0, 0, 1],
    [1, 0, 2, 0, 0, 7, 0, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1],
    [1, 0, 0, 2, 0, 0, 4, 0, 0, 0, 0, 3, 0, 0, 3, 0, 0, 0, 0, 1],
    [1, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 2, 2, 2, 2, 2, 0, 0, 0, 1],
    [1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1],
    [1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 7, 0, 7, 0, 0, 0, 0, 2, 0, 1],
    [1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1],
    [1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 2, 0, 2, 2, 2, 2, 2, 1],
    [1, 0, 0, 0, 0, 0, 2, 2, 2, 6, 6, 6, 6, 6, 1, 1, 1, 1, 1, 1],
    [1, 0, 0, 0, 0, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1],
    [1, 0, 0, 0, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1],
    [1, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]
]

# TEMPAT MENURUNKAN PLAYER DI AWAL PERMAINAN
Player = player(100, screen_height - 150)
world = World(world_data)

run = True
while run:
    clock.tick(fps)  # MENGATUR PERGERAKAN PLAYER, SEMAKIN BANYAK SEMAKIN CEPAT
    screen.blit(bg_img, (0, 0))
    world.draw()
    Player.update()
    # draw_grid()
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            run = False
    pygame.display.update()

pygame.quit()
