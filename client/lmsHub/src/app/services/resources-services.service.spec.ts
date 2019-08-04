import { TestBed } from '@angular/core/testing';

import { ResourcesServicesService } from './resources-services.service';

describe('ResourcesServicesService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ResourcesServicesService = TestBed.get(ResourcesServicesService);
    expect(service).toBeTruthy();
  });
});
